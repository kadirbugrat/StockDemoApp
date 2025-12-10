package com.projects.stockDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.stockDemo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides basic CRUD operations
    // Additional custom queries can be defined here if needed
    
    // For example:
    // List<Product> findByCategory(String category);
    // Product findByName(String name);
}
