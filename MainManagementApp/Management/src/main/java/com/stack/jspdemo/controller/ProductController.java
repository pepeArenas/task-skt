package com.stack.jspdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stack.jspdemo.model.ProductDTO;
import com.stack.jspdemo.service.ProductService;

@Controller
public class ProductController {

	ProductService productService;
	ProductDTO product;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String showProductPage(ModelMap model) {
		model.put("product", new ProductDTO());
		return "product";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String showProductsPage(ModelMap model) {
		model.put("products", productService.printAllProducts());
		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String showAddedProductPage(ModelMap model, @Valid ProductDTO product, BindingResult result) {
		if (result.hasErrors()) {
			return "product";
		}
		productService.addProduct(product);
		return "/menu";
	}
}
