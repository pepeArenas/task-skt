package com.stack.jspdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableRabbit
@ComponentScan
@SpringBootApplication
public class ManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementAppApplication.class, args);
	}

}
