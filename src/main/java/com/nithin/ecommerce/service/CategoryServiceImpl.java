package com.nithin.ecommerce.service;

import com.nithin.ecommerce.dto.CategoryRequest;
import com.nithin.ecommerce.entity.Category;
import com.nithin.ecommerce.exception.CategoryAlreadyExistsException;
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

        String categoryName = request.getName().trim().toUpperCase();

        if (categoryRepository.existsByName(categoryName)) {
            throw new CategoryAlreadyExistsException(
                    "Category '" + categoryName + "' already exists."
            );
        }
        // above we did validation first so before creating object or saving, doing validation is
        // the best practice if validation fails then no object creation CLEAN AND CLEAR and control exits!
        Category category = new Category();

        category.setName(categoryName);
        category.setDescription(request.getDescription().trim());
        category.setActive(true);
        category.setCreatedAt(LocalDateTime.now());


            categoryRepository.save(category);

    }
}