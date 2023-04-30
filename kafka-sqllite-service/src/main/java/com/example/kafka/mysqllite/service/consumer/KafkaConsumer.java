package com.example.kafka.mysqllite.service.consumer;

import java.util.List;

public interface KafkaConsumer {
    void recieve(List<String> messages, List<Integer> keys, List<Integer> partition, List<Long> offsets);
}
