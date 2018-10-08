package com.stack.jspdemo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stack.jspdemo.model.ProductDTO;
import com.stack.jspdemo.rabbit.consumer.Consumer;
import com.stack.jspdemo.rabbit.producer.Producer;

@Service
public class ProductService implements MessageListener {

	@Autowired
	public ProductService() {
	}

	@Autowired
	Producer producer;

	@Autowired
	Consumer consumer;

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static List<ProductDTO> products = new ArrayList<>();

	public ProductDTO addProduct(ProductDTO product) {
		producer.produce(product);
		products.add(product);
		return product;
	}

	public List<ProductDTO> findAll() {
		System.out.println(products.toString());
		return products;
	}

	// @RabbitListener(queues = "${jsa.rabbitmq.queue2}", containerFactory =
	// "jsaFactory2")
	public void findAll(Message message) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		byte[] body = message.getBody();
		String s = new String(body);
		ProductDTO[] p = mapper.readValue(s, ProductDTO[].class);
		for (ProductDTO product : p) {
			products.add(product);
		}
		// message.getMessageProperties().getReplyTo();

	}

	@Override
	public void onMessage(Message message) {
		System.out.println("message " + new String(message.getBody()));

		ObjectMapper mapper = new ObjectMapper();

		byte[] body = message.getBody();
		String s = new String(body);
		ProductDTO[] p;
		try {
			p = mapper.readValue(s, ProductDTO[].class);
			for (ProductDTO product : p) {
				// System.out.println(p);
				products.add(product);
			}
			printAllProducts();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//@RabbitListener(queues = "${jsa.rabbitmq.queue2}", containerFactory = "jsaFactory2")
	public List<ProductDTO> printAllProducts() {
		for (ProductDTO product : products) {
			System.out.println("Desde metodo printAllProducts" + product);
		}
		return products;

	}

}
