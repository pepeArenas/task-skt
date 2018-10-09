package com.stack.jspdemo.repository;

import java.util.List;

import com.stack.jspdemo.entity.Product;

public interface ProductRepositoryCustom {
	List<Product> getAllProducts();

	void insertProduct(Product product);

}
