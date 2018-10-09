package com.stack.jspdemo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ProductDTO implements Serializable {
	private Integer id;
	@Size(min = 3, max = 45, message = "Name should be between 3 and 45 characters")
	private String name;
	@Size(min = 3, max = 45, message = "Model should be between 3 and 45 characters")
	private String model;
	@Min(value = 0L, message = "The value must be positive")
	@Digits(integer = 5, fraction = 2, message = "Price shoud be 5 integer tops and 2 decimal")
	private BigDecimal price;

	public ProductDTO() {
	}

	public ProductDTO(String name) {
		this.name = name;
	}

	public ProductDTO(Integer id, String name, String model, BigDecimal price) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Product [id=%s, name=%s, model=%s, price=%s]", id, name, model, price);
	}
}