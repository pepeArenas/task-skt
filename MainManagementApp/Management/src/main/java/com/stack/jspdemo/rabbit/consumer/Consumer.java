package com.stack.jspdemo.rabbit.consumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stack.jspdemo.model.Product;
import com.stack.jspdemo.service.ProductService;

@Component
public class Consumer {
	
//	@Autowired
//	ProductService productService;
//
//	@RabbitListener(queues = "${jsa.rabbitmq.queue2}", containerFactory = "jsaFactory")
//	public String recievedMessage(Message message) throws JsonParseException, JsonMappingException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//
//		byte[] body = message.getBody();
//		String s = new String(body);
//		System.out.println("DDDD " + s);
//
//		Product[] p = mapper.readValue(s, Product[].class);
//		for (int i=0;i<p.length;i++) {
//			System.out.println(p[i].getName());	
//		}
//		
//		//productService.findAll();
//		
//		return "";
//	}

}
