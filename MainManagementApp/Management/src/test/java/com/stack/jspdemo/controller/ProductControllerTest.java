package com.stack.jspdemo.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;

import com.stack.jspdemo.model.ProductDTO;
import com.stack.jspdemo.rabbit.producer.Producer;
import com.stack.jspdemo.service.ProductService;

public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;
	
	@Mock
	private ProductService productService;
	@Mock
	private Producer producer;
	@Mock
	private RabbitTemplate rabbitTemplate;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShowSaveProduct() {
		ProductDTO productDTO = new ProductDTO();

		productDTO.setId(1);
		productDTO.setName("destornillador");
		productDTO.setModel("A09998");
		productDTO.setPrice(new BigDecimal("12.22"));
		when(productService.addProduct(productDTO)).thenReturn(productDTO);
		String resultPage = productController.showAddedProductPage(new ModelMap(), productDTO, new BeanPropertyBindingResult("", "command"));
		verify(productService).addProduct(productDTO);
		assertTrue(resultPage.equals("/menu"));
	}
	
	@Test
	public void testShowIncorrectSaveProduct() {
		ProductDTO productDTO = new ProductDTO();

		productDTO.setId(1);
		productDTO.setName("destornillador");
		productDTO.setModel("A09998");
		productDTO.setPrice(new BigDecimal("12.22"));
		when(productService.addProduct(productDTO)).thenReturn(productDTO);
		String resultPage = productController.showAddedProductPage(new ModelMap(), productDTO, new BeanPropertyBindingResult("", "command"));
		verify(productService).addProduct(productDTO);
		assertTrue(!resultPage.equals("otherPage"));
	}
	
	@Test
	public void testShowFindAllProductsPage() {
		Set<ProductDTO> products = new HashSet<>();
		
		ProductDTO destornillador = new ProductDTO();
		destornillador.setId(1);
		destornillador.setName("destornillador");
		destornillador.setModel("A09998");
		destornillador.setPrice(new BigDecimal("12.22"));
		products.add(destornillador);
		
		ProductDTO martillo = new ProductDTO();
		martillo.setId(2);
		martillo.setName("destornillador");
		martillo.setModel("A09998");
		martillo.setPrice(new BigDecimal("12.22"));
		products.add(martillo);
		
		when(productService.findAll()).thenReturn(products);
		ModelMap model = new ModelMap();
		model.put("products", products);
		
		String resultPage = productController.showProductsPage(model);
		assertTrue(resultPage.equals("products"));
	}
	
	@Test
	public void testShowIncorrectFindAllProductsPage() {
		Set<ProductDTO> products = new HashSet<>();
		
		ProductDTO destornillador = new ProductDTO();
		destornillador.setId(1);
		destornillador.setName("destornillador");
		destornillador.setModel("A09998");
		destornillador.setPrice(new BigDecimal("12.22"));
		products.add(destornillador);
		
		ProductDTO martillo = new ProductDTO();
		martillo.setId(2);
		martillo.setName("destornillador");
		martillo.setModel("A09998");
		martillo.setPrice(new BigDecimal("12.22"));
		products.add(martillo);
		
		when(productService.findAll()).thenReturn(products);
		ModelMap model = new ModelMap();
		model.put("products", products);
		
		String resultPage = productController.showProductsPage(model);
		assertTrue(!resultPage.equals("otherPage"));
	}


}
