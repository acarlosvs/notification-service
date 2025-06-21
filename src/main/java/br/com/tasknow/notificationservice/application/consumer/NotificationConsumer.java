package br.com.tasknow.notificationservice.application.consumer;

import br.com.tasknow.notificationservice.domain.model.Notification;
import br.com.tasknow.notificationservice.domain.service.NotificationService;
import br.com.tasknow.notificationservice.domain.service.S3Servive;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final S3Servive s3Servive;
    private final NotificationService notificationService;

    @RabbitListener(queues = "tasknow.notification.send.v1.q")
    public void send(Message message) throws JsonProcessingException {
        String body = new String(message.getBody());

        try {
            notificationService.send(new ObjectMapper().readValue(body, Notification.class));
        } catch (Exception ex) {
            int retryCount = (int) message.getMessageProperties().getHeaders().get("x-retry-count");
            if (retryCount > 3)
                throw ex;

            s3Servive.upload("failed-notification-" + LocalDateTime.now() + ".json", body);
        }
    }
}
