package com.kafka.kafka_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.kafka.kafka_consumer.record.OrderRecord;

@Service
public class OrderService {

	 // @KafkaListener(topics = "napoleao-order-processed", containerFactory = "orderKafkaListenerContainerFactory")
	@KafkaListener(topicPartitions = @TopicPartition(topic = "teste-order-processed", partitions = { "0" }), containerFactory = "orderKafkaListenerContainerFactory")
    public void orderListener(OrderRecord order) {
        System.out.println("Received Message Consumer 02: " + order.name());
    }
	
}
