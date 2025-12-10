package com.projects.stockDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.stockDemo.model.Product;
import com.projects.stockDemo.model.StockItem;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {
    // JpaRepository provides basic CRUD operations
    // Additional custom queries can be defined here if needed

    // Product-specific query example
    Optional<StockItem> findByProduct(Product product);
    
}
