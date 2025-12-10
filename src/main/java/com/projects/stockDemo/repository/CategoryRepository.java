package com.projects.stockDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.stockDemo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // JpaRepository provides basic CRUD operations
    // Additional custom queries can be defined here if needed
    
}
