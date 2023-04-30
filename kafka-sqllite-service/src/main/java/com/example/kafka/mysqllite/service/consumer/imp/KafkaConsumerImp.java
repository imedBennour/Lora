package com.example.kafka.mysqllite.service.consumer.imp;

import com.example.kafka.mysqllite.service.consumer.KafkaConsumer;
import com.example.kafka.mysqllite.service.consumer.config.KafkaConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KafkaConsumerImp implements KafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerImp.class);

    private final KafkaConfigData kafkaConfigData;

    public KafkaConsumerImp(KafkaConfigData kafkaConfigData) {
        this.kafkaConfigData = kafkaConfigData;
    }
    @Override
    @KafkaListener(id = "gpsTopicListener",topics = "${kafka-config.topic-name}")
    public void recieve(@Payload List<String> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<Integer> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partition,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        LOG.info("{} number of messages received with keys {}, partitions {} and offsets {} "+
                "sending to elastic threadId {}",
                messages.size(),
                keys.toString(),
                partition.toString(),
                offsets.toString(),
                Thread.currentThread().getId()
                );

    }
}
