package com.stack.jspdemo.model;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

public class Product {
	private Integer id;
	@Size(min = 3, max = 45, message = "Name should be between 3 and 45 characters")
	private String name;
	@Size(min = 3, max = 45, message = "Model should be between 3 and 45 characters")
	private String model;
	private String price;

	public Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	public Product(Integer id, String name, String model, String price) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
