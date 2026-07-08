package com.nithin.ecommerce.service;

import com.nithin.ecommerce.dto.CategoryRequest;
import com.nithin.ecommerce.entity.Category;
import com.nithin.ecommerce.repository.CategoryRepository;
import com.nithin.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    @Override
    public void createCategory(CategoryRequest request) {
        System.out.println("Service Impl");
        Category category = new Category();

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        category.setActive(true);
        category.setCreatedAt(LocalDateTime.now());

        categoryRepository.save(category);

    }
}