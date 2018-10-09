package com.stack.jspdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stack.jspdemo.entity.Product;
import com.stack.jspdemo.rabbit.producer.Producer;
import com.stack.jspdemo.repository.ProductRepository;

@Component
public class ProductService {
	public static List<Product> products = new ArrayList<>();

	@Autowired
	Producer producer;
	@Autowired
	private ProductRepository repo;
	@Autowired
	ProductService productService;

	public void findAll() {
		producer.produce(repo.getAllProducts());
	}

	@RabbitListener(queues = "${jsa.rabbitmq.queue}", containerFactory = "jsaFactory")
	public void save(Product product) {
		repo.insertProduct(product);
		findAll();
	}

}
