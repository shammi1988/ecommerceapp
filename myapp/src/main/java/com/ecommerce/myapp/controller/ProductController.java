package com.ecommerce.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.myapp.entity.Product;

import com.ecommerce.myapp.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The ProductController class handles all HTTP requests related to products. It
 * uses the ProductService to interact with the database.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@GetMapping("/category/{categoryId}")
	public List<Product> getAllProductsByCategory(@PathVariable Long categoryId) {
		return productService.getAllProductsByCategory(categoryId);
	}

	@PostMapping("/category/{categoryId}")
	public Product addProductToCategory(@PathVariable Long categoryId, @RequestBody Product product) {
		return productService.addProductToCategory(categoryId, product);
	}

	@GetMapping("/getall")
	public Page<Product> getAllProducts(Pageable pageable) {
		return productService.findAllProducts(pageable);
	}
	
	

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping("/createproduct")
	public Product createProduct(@RequestBody Product product) {
		logger.error("post");
		return productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product existingProduct = productService.getProductById(id);
		if (existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setImage(product.getImage());
			return productService.saveProduct(existingProduct);
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

	@DeleteMapping("/category/{categoryId}")
	public String deleteProductsByCategory(@PathVariable Long categoryId) {
		productService.deleteProductsByCategory(categoryId);
		return "All products in category " + categoryId + " have been deleted.";
	}

}
