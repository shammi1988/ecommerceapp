package com.ecommerce.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.myapp.entity.Product;
import com.ecommerce.myapp.entity.ProductCategory;
import com.ecommerce.myapp.repository.ProductCategoryRepository;
import com.ecommerce.myapp.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public List<Product> getAllProductsByCategory(Long categoryId) {
		ProductCategory category = productCategoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		return category.getProducts();
	}

	public Product addProductToCategory(Long categoryId, Product product) {
		ProductCategory category = productCategoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		product.setCategory(category);
		return productRepository.save(product);
	}

	public Page<Product> findAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Product removed !! " + id;
	}

	public void deleteProductsByCategory(Long categoryId) {
		ProductCategory category = productCategoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		List<Product> products = category.getProducts();
		for (Product product : products) {
			productRepository.delete(product);
		}
	}

}
