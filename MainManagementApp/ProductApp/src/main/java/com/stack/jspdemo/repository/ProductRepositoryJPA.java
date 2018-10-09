package com.stack.jspdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.stack.jspdemo.entity.Product;

public interface ProductRepositoryJPA extends CrudRepository<Product, Integer> {

}
