package com.kafka.kafka_producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafka_producer.record.OrderRecord;
import com.kafka.kafka_producer.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	public final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public void createOrder(@RequestBody OrderRecord order) {
		orderService.sendMessageOrder(order);
	}
	
}
