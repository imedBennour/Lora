package com.example.kafka.mysqllite.service.consumer.imp;

import com.example.kafka.mysqllite.service.consumer.KafkaConsumer;
import com.example.kafka.mysqllite.service.consumer.config.KafkaConfigData;

import com.example.kafka.mysqllite.service.entities.Gps;
import com.example.kafka.mysqllite.service.services.GpsService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
    private final GpsService gpsService;

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerImp.class);

    private final KafkaConfigData kafkaConfigData;

    public KafkaConsumerImp(GpsService gpsService, KafkaConfigData kafkaConfigData) {
        this.gpsService = gpsService;
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

        for (int i = 0; i < messages.size(); i++) {
            messages.forEach(message -> LOG.info("saving :"+ message.toString()));
            JsonObject jsonObject = new JsonParser().parse(messages.get(i)).getAsJsonObject();
            Gps gps = new Gps(jsonObject.get("date_time").getAsString(),
                    jsonObject.get("lat").getAsDouble(),
                    jsonObject.get("log").getAsDouble());
            gpsService.saveData(gps);
        }



    }
}
