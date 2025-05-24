package br.com.tasknow.notificationservice.domain.service;

import br.com.tasknow.notificationservice.domain.model.Notification;

public interface NotificationService {
    Notification send(Notification notification);
    void sendAsync(Notification notification);
}
