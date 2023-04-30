package com.example.kafka.mysqllite.service.consumer.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-consumer-config")
public class KafkaConsumerConfigData {
    private String keyDeserializer;
    private String valueDeserializer;
    private String  consumerGroupId;
    private Boolean batchListener;
    private Boolean autoStartup;
    private String autoOffsetReset;
    private Integer concurrencyLevel;
    private Integer batchSize;
    private Integer batchSizeBoostFactor;
    private Integer sessionTimeoutMs;
    private Integer requestTimoutMs;
    private Integer retryCount;
    private Integer heartbeatIntervalMs;
    private Integer maxPollIntervalMs;
    private Integer maxPollRecord;

    private Integer maxPartitionFetchBytesDefault;
    private Integer maxPartitionFetchBytesBoostFactor;
    private Long pollTimeoutMs;

}
