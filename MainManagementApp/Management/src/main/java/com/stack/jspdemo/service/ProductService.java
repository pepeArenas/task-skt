package com.stack.jspdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.jspdemo.model.Product;

@Service
public class ProductService {
	
	@Autowired
	public ProductService() {
	}
	
	public static List<Product> products = new ArrayList<>();


	static {
		products.add(new Product(1, "tuerca", "modelo1", "20.30"));
		products.add(new Product(2, "tornillo", "modelo2", "10.30"));
		products.add(new Product(3, "destornillador", "modelo3", "40.30"));
	}

	public Product addProduct(Product product) {
	
		products.add(product);
		return product;
	}

	public List<Product> findAll() {

		return products;
	}

}
