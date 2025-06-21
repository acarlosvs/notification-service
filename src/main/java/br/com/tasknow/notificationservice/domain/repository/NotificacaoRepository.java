package br.com.tasknow.notificationservice.domain.repository;

import br.com.tasknow.notificationservice.domain.model.Notification;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface NotificacaoRepository extends CrudRepository<Notification, UUID> {

}
