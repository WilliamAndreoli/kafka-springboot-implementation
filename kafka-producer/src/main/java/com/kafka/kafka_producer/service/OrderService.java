package com.kafka.kafka_producer.service;

import java.util.Random;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.kafka_producer.record.OrderRecord;

@Service
public class OrderService {

	private final KafkaTemplate<String, OrderRecord> kafkaTemplateOrder;

	private final Random random = new Random();

	public OrderService(KafkaTemplate<String, OrderRecord> kafkaTemplateOrder) {
		this.kafkaTemplateOrder = kafkaTemplateOrder;
	}

	@SuppressWarnings("null")
	public void sendMessageOrder(OrderRecord order) {
		int partition = random.nextInt(2);
		System.out.println("Sent message to parition: " + partition);
		System.out.println("Sending Order: " + order.name());
		kafkaTemplateOrder.send("teste-order-processed", partition, null, order);
	}

}
