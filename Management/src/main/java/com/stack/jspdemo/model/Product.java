package com.stack.jspdemo.model;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private Integer id;
	@Size(min = 10, message = "Enter at least 10 characters")
	private String name;
	private String model;
	private String price;

	public Product() {

	}

	public Product(Integer id, String name, String model, String price) {
		super();
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

	public Product(String name) {
		super();
		this.name = name;
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
