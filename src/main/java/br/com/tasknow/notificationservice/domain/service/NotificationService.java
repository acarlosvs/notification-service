package br.com.tasknow.notificationservice.domain.service;

import br.com.tasknow.notificationservice.domain.model.Notification;
import reactor.core.publisher.Mono;

public interface NotificationService {
    void sendAsync(Notification notification);
    Notification send(Notification notification);
}
