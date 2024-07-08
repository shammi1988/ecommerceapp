package com.ecommerce.myapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecommerce.myapp.entity.Product;
import com.ecommerce.myapp.service.ProductService;

public class ProductControllerTest {
	/*
	 * @InjectMocks private ProductController productController;
	 * 
	 * @Mock private ProductService productService;
	 * 
	 * @BeforeEach public void init() { MockitoAnnotations.openMocks(this); }
	 * 
	 * @Test public void getAllProducts_returnsProductList() { Product product1 =
	 * new Product(); Product product2 = new Product();
	 * when(productService.getAllProducts()).thenReturn(Arrays.asList(product1,
	 * product2));
	 * 
	 * List<Product> result = productController.getAllProducts();
	 * 
	 * assertEquals(2, result.size()); verify(productService,
	 * times(1)).getAllProducts(); }
	 * 
	 * @Test public void getProductById_returnsProduct() { Product product = new
	 * Product(); when(productService.getProductById(1L)).thenReturn(product);
	 * 
	 * Product result = productController.getProductById(1L);
	 * 
	 * assertEquals(product, result); verify(productService,
	 * times(1)).getProductById(1L); }
	 * 
	 * @Test public void createProduct_returnsCreatedProduct() { Product product =
	 * new Product();
	 * when(productService.saveProduct(any(Product.class))).thenReturn(product);
	 * 
	 * Product result = productController.createProduct(product);
	 * 
	 * assertEquals(product, result); verify(productService,
	 * times(1)).saveProduct(product); }
	 * 
	 * @Test public void updateProduct_returnsUpdatedProduct() { Product product =
	 * new Product(); when(productService.getProductById(1L)).thenReturn(product);
	 * when(productService.saveProduct(any(Product.class))).thenReturn(product);
	 * 
	 * Product result = productController.updateProduct(1L, product);
	 * 
	 * assertEquals(product, result); verify(productService,
	 * times(1)).getProductById(1L); verify(productService,
	 * times(1)).saveProduct(product); }
	 * 
	 * @Test public void updateProduct_returnsNullWhenProductNotFound() {
	 * when(productService.getProductById(1L)).thenReturn(null);
	 * 
	 * Product result = productController.updateProduct(1L, new Product());
	 * 
	 * assertEquals(null, result); verify(productService,
	 * times(1)).getProductById(1L); }
	 * 
	 * @Test public void deleteProduct_callsDeleteProduct() {
	 * productController.deleteProduct(1L);
	 * 
	 * verify(productService, times(1)).deleteProduct(1L); }
	 */
}