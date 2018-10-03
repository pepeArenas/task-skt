package com.stack.jspdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stack.jspdemo.model.Product;
import com.stack.jspdemo.repository.ProductRepository;

@Component
public class ProductService {
	public static List<Product> products = new ArrayList<>();

	private static int userCount = 3;

	@Autowired
	private ProductRepository repo;

	public List<Product> findAll() {

		return repo.getAllProducts();
	}

	public Product save(Product product) {
		// products.add(product);
		repo.insertProduct(product);

		return product;
	}
}
