package com.ecommerce.product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @requestMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
