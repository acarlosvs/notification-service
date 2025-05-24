package br.com.tasknow.notificationservice.domain.repository;

import br.com.tasknow.notificationservice.domain.model.Notification;

public interface NotificacaoRepository {
    Notification save(Notification notification);
}
