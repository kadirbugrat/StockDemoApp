package com.projects.stockDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.stockDemo.model.Category;
import com.projects.stockDemo.repository.CategoryRepository;

@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
    }

    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }
}
