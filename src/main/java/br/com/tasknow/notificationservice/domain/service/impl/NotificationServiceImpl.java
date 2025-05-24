package br.com.tasknow.notificationservice.domain.service.impl;

import br.com.tasknow.notificationservice.domain.model.Notification;
import br.com.tasknow.notificationservice.domain.repository.NotificacaoRepository;
import br.com.tasknow.notificationservice.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificacaoRepository notificacaoRepository;

    @Override
    public Notification send(Notification notification) {
        notification.setId(UUID.randomUUID());
        return notificacaoRepository.save(notification);
    }

    @Async
    @Override
    public void sendAsync(Notification notification) {
        send(notification);
    }
}
