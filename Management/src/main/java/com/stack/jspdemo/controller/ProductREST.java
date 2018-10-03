package com.stack.jspdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stack.jspdemo.model.Product;
import com.stack.jspdemo.service.ProductService;

@RestController
public class ProductREST {

	@Autowired
	ProductService productService;
	@Autowired
	Product product;

	@PostMapping("/products/add")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}

}
