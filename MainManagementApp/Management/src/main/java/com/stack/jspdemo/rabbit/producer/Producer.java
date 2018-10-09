package com.stack.jspdemo.rabbit.producer;

import java.util.logging.Logger;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.stack.jspdemo.model.ProductDTO;
import com.stack.jspdemo.service.ProductService;

@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;

	@Value("${jsa.rabbitmq.routingkey}")
	private String routingkey;
	private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

	public void produce(ProductDTO product) {

		amqpTemplate.convertAndSend(exchange, routingkey, product);
		LOGGER.info("Send msg = " + product);
	}
}