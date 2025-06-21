package br.com.tasknow.notificationservice.application.controller;

import br.com.tasknow.notificationservice.domain.model.Notification;
import br.com.tasknow.notificationservice.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/notification/send")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/async")
    public ResponseEntity<Void> sendAsync(@RequestBody Notification notification) {
        notificationService.sendAsync(notification);
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<Notification> send(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.send(notification));
    }
}
