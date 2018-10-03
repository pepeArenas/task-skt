package com.stack.jspdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stack.jspdemo.model.Product;
import com.stack.jspdemo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	Product product;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String showProductPage(ModelMap model) {
		model.put("product", new Product());
		return "product";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String showProductsPage(ModelMap model) {
		model.put("products", productService.findAll());
		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String showAddedProductPage(ModelMap model, @Valid Product product, BindingResult result) {
		if (product.getName().equals("jesus")) {
			throw new RuntimeException("Ocurrio un error");
		}

		if (result.hasErrors()) {
			return "product";
		}

		productService.addProduct(product);

		return "redirect:/products";
	}

}
