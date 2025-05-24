package br.com.tasknow.notificationservice.commons.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public DirectExchange sendNotificationExchange() {
        return new DirectExchange("tasknow.notification.send.v1.e");
    }

    @Bean
    public Queue sendNotificationQueue() {
        return QueueBuilder
                .durable("tasknow.notification.send.v1.q")
                .build();
    }

    @Bean
    public Binding sendNotificationBinding() {
        return BindingBuilder
                .bind(sendNotificationQueue())
                .to(sendNotificationExchange())
                .with("tasknow.notification.send.v1.r");
    }
}
