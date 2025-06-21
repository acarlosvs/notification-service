package br.com.tasknow.notificationservice.domain.service;

public interface S3Servive {
    void upload(String key, String message);
}
