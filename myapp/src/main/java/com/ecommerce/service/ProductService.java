package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
        return productRepository.findAll();
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
	

}
