package com.example.springscheduler.message;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfig {

    @Bean
    public QueueMessagingTemplate getQueueMessagingTemplate() {
        AmazonSQSAsync sqsAsync = AmazonSQSAsyncClientBuilder.defaultClient();
        return new QueueMessagingTemplate(sqsAsync);
    }
}
