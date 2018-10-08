package com.stack.jspdemo.rabbit.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.stack.jspdemo.model.ProductDTO;

@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;

	@Value("${jsa.rabbitmq.routingkey}")
	private String routingkey;

	public void produce(ProductDTO product) {
		
		amqpTemplate.convertAndSend(exchange, routingkey, product);
		System.out.println("Send msg = " + product);
	}
}