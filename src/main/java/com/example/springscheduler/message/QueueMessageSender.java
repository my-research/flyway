package com.example.springscheduler.message;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class QueueMessageSender {

    private final QueueMessagingTemplate queueMessagingTemplate;
    // private final SqsConfig sqsConfig;

    public void send() {
        queueMessagingTemplate.convertAndSend("TEST-JK-1", "some message");
    }

}
