package com.stack.jspdemo.rabbit.producer;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.stack.jspdemo.entity.Product;

@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${jsa.rabbitmq.exchange3}")
	private String exchange;

	@Value("${jsa.rabbitmq.routingkey3}")
	private String routingkey;

	public void produce(List<Product> products) {

		amqpTemplate.convertAndSend(exchange, routingkey, products);
		System.out.println("Send msg = " + products);
	}
}
