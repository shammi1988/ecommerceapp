package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

/**
 * The ProductController class handles all HTTP requests related to products. It
 * uses the ProductService to interact with the database.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

	/**
	 * The ProductService is used to interact with the database. It is automatically
	 * injected by Spring Framework.
	 */
	@Autowired
	private ProductService productService;

	/**
	 * Handles the mapping for "/products" endpoint. Returns a list of all products.
	 *
	 * @return List of products
	 */
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product existingProduct = productService.getProductById(id);
		if (existingProduct != null) {
			existingProduct.setName(product.getName());
            existingProduct.setDesc(product.getDesc());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImagePath(product.getImagePath());
            return productService.saveProduct(existingProduct);
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

}
