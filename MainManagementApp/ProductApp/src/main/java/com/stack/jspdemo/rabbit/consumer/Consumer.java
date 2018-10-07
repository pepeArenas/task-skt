package com.stack.jspdemo.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stack.jspdemo.model.Product;
import com.stack.jspdemo.repository.ProductRepository;

@Component
public class Consumer {
	@Autowired
	private ProductRepository repo;

	@RabbitListener(queues = "${jsa.rabbitmq.queue}", containerFactory = "jsaFactory")
	public void recievedMessage(Product product) {
		repo.insertProduct(product);
		//return product;

	}

}
