package br.com.tasknow.notificationservice.application.consumer;

import br.com.tasknow.notificationservice.domain.model.Notification;
import br.com.tasknow.notificationservice.domain.service.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "tasknow.notification.send.v1.q")
    public void send(String message) throws JsonProcessingException {
        notificationService.sendAsync(new ObjectMapper().readValue(message, Notification.class));
    }

}
