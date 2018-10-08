package com.stack.jspdemo.rabbit.consumer;

import org.springframework.stereotype.Component;

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
