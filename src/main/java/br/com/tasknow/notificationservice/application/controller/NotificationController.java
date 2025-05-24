package br.com.tasknow.notificationservice.application.controller;

import br.com.tasknow.notificationservice.domain.model.Notification;
import br.com.tasknow.notificationservice.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification/send")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> send(Notification notification) {
        return ResponseEntity.ok(notificationService.send(notification));
    }

    @PostMapping("/async")
    public ResponseEntity<Void> sendAsync(Notification notification) throws InterruptedException {
        notificationService.sendAsync(notification);
        return ResponseEntity.accepted().build();
    }
}
