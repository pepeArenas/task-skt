package com.stack.jspdemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.stack.jspdemo.model.Product;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Product> getAllProducts() {
		StoredProcedureQuery findByYearProcedure = em.createNamedStoredProcedureQuery("findAllProducts");
		return findByYearProcedure.getResultList();
	}

	@Override
	public void insertProduct(Product product) {
		System.out.println(product.getName());
		StoredProcedureQuery insert = em.createNamedStoredProcedureQuery("insertProduct");
		insert.setParameter("productName", product.getName());
		insert.setParameter("model", product.getModel());
		insert.setParameter("price", product.getPrice());
		insert.execute();
	}
}
