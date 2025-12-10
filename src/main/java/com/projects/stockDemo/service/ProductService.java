package com.projects.stockDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.stockDemo.model.Category;
import com.projects.stockDemo.model.Product;
import com.projects.stockDemo.repository.ProductRepository;

@Service
public class ProductService {

    // Dependencies
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    // Constructor Injection
    public ProductService (ProductRepository productRepository, CategoryService categoryService){
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    
    public Product createProduct(String name, Double price, Long categoryId) {

        Category category = categoryService.getCategoryById(categoryId);

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product getProductById (Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    
}
