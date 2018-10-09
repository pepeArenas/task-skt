package com.stack.jspdemo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "PRODUCT")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "findAllProducts", procedureName = "getAllProducts", resultClasses = {
				Product.class }),
		@NamedStoredProcedureQuery(name = "insertProduct", procedureName = "insertProd", parameters = {
				@StoredProcedureParameter(name = "productName", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "model", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "price", type = BigDecimal.class, mode = ParameterMode.IN), }) })
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 3, max = 45, message = "Name should be between 3 and 45 characters")
	private String name;
	@Size(min = 3, max = 45, message = "Model should be between 3 and 45 characters")
	private String model;
	@Min(value = 0L, message = "The value must be positive")
	@Digits(integer = 5, fraction = 2, message = "Price shoud be 5 integer tops and 2 decimal")
	private BigDecimal price;

	public Product() {

	}

	public Product(Integer id, String name, String model, BigDecimal price) {
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", model=" + model + ", price=" + price + "]";
	}

}
