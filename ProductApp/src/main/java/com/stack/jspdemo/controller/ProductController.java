package com.stack.jspdemo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.stack.jspdemo.model.Product;
import com.stack.jspdemo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/products")
	public List<Product> retrieveAllProducts() {
		return service.findAll();
	}

	@PostMapping("/products")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody Product product) {
		Product savedProduct = service.save(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}