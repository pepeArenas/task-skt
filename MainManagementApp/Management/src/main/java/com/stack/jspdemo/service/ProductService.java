package com.stack.jspdemo.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stack.jspdemo.model.ProductDTO;
import com.stack.jspdemo.rabbit.producer.Producer;

@Service
public class ProductService implements MessageListener {
	private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

	public static Set<ProductDTO> products = new HashSet<>();

	public ProductService() {
	}

	@Autowired
	Producer producer;

	@Autowired
	RabbitTemplate rabbitTemplate;

	public ProductDTO addProduct(ProductDTO product) {
		producer.produce(product);
		return product;
	}

	public Set<ProductDTO> findAll() {
		LOGGER.info(products.toString());
		return products;
	}

	public void findAll(Message message) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		byte[] body = message.getBody();
		String s = new String(body);
		ProductDTO[] p = mapper.readValue(s, ProductDTO[].class);
		for (ProductDTO product : p) {
			products.add(product);
		}
	}

	@Override
	public void onMessage(Message message) {
		LOGGER.info("message " + new String(message.getBody()));
		ObjectMapper mapper = new ObjectMapper();

		byte[] body = message.getBody();
		String s = new String(body);
		ProductDTO[] p;
		try {
			p = mapper.readValue(s, ProductDTO[].class);
			for (ProductDTO product : p) {
				products.add(product);
			}
			printAllProducts();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Set<ProductDTO> printAllProducts() {
		for (ProductDTO product : products) {
			LOGGER.info("Desde metodo printAllProducts " + product);
		}
		return products;

	}

}
