package com.stack.jspdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.stack.jspdemo.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>, ProductRepositoryCustom{

}
