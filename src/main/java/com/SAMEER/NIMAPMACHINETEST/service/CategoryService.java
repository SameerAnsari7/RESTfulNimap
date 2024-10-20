package com.SAMEER.NIMAPMACHINETEST.service;

import com.SAMEER.NIMAPMACHINETEST.model.Category;
import com.SAMEER.NIMAPMACHINETEST.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getAllCategories(int page) {
        return categoryRepository.findAll(PageRequest.of(page, 10));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> updateCategory(Long id, Category category) {
        if (!categoryRepository.existsById(id)) {
            return Optional.empty();
        }
        category.setId(id);
        return Optional.of(categoryRepository.save(category));
    }

    public boolean deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }
}
