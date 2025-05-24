package br.com.tasknow.notificationservice.domain.repository;

import br.com.tasknow.notificationservice.domain.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NotificacaoRepositoryImpl implements NotificacaoRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    public Notification save(Notification notification) {
        String key = "notification:" + notification.getId().toString();
        redisTemplate.opsForValue().set(key, notification);
        return (Notification) redisTemplate.opsForValue().get(key);
    }
}
