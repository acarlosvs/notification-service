package br.com.tasknow.notificationservice.domain.service.impl;

import br.com.tasknow.notificationservice.domain.service.S3Servive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@RequiredArgsConstructor
public class S3ServiveImpl implements S3Servive {

    private final S3Client s3Client;

    public void upload(String key, String message) {
        s3Client.putObject(PutObjectRequest
                        .builder()
                        .bucket("")
                        .key(key)
                        .build(),
                RequestBody.fromBytes(message.getBytes()));
    }
}
