package com.example.kafka.mysqllite.service;

import com.example.kafka.mysqllite.service.consumer.config.KafkaConfigData;
import com.example.kafka.mysqllite.service.consumer.config.KafkaConsumerConfig;
import com.example.kafka.mysqllite.service.consumer.config.KafkaConsumerConfigData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@EnableConfigurationProperties({KafkaConfigData.class, KafkaConsumerConfigData.class})
public class KafkaMysqlliteServiceApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(KafkaMysqlliteServiceApp.class, args);
    }
}
