package com.nithin.ecommerce.service;

import com.nithin.ecommerce.dto.CategoryRequest;
import com.nithin.ecommerce.dto.CategoryResponse;
import com.nithin.ecommerce.entity.Category;
import com.nithin.ecommerce.exception.CategoryAlreadyExistsException;
import com.nithin.ecommerce.exception.CategoryNotFoundException;
import com.nithin.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    @Override
    public CategoryResponse createCategory(CategoryRequest request) {

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


        Category savedCategory= categoryRepository.save(category);

        CategoryResponse response = new CategoryResponse();

        response.setId(savedCategory.getId());
        response.setName(savedCategory.getName());
        response.setDescription(savedCategory.getDescription());

        return response;
    }
    
    @Override
    public List<CategoryResponse> findAll(){
        List<Category> categories = categoryRepository.findAll();

        List<CategoryResponse> responses = new ArrayList<>();

        for (Category category : categories) {

            CategoryResponse response = new CategoryResponse();

            response.setId(category.getId());
            response.setName(category.getName());
            response.setDescription(category.getDescription());

            responses.add(response);
        }

        return responses;
    }

    @Override
    public CategoryResponse findById(Long id) {

        Category category =
                categoryRepository.findById(id)
                        .orElseThrow(
                                () -> new CategoryNotFoundException("Category with id "+ id+ " not found.")
                        );

        CategoryResponse response = new CategoryResponse();

        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());

        return response;
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest request) {

        Category category =
                categoryRepository.findById(id)
                        .orElseThrow(
                                () -> new CategoryNotFoundException(
                                        "Category with id "
                                                + id
                                                + " not found."
                                )
                        );


        category.setName(
                request.getName().trim().toUpperCase()
        );

        category.setDescription(
                request.getDescription().trim()
        );

        category.setUpdatedAt(LocalDateTime.now());



        Category savedCategory= categoryRepository.save(category);

        CategoryResponse response = new CategoryResponse();

        response.setId(savedCategory.getId());
        response.setName(savedCategory.getName());
        response.setDescription(savedCategory.getDescription());

        return response;
    }

    @Override
    public void deleteCategory(Long id) {
        Category category =
                categoryRepository.findById(id)
                        .orElseThrow(
                                () -> new CategoryNotFoundException(
                                        "Category with id "
                                                + id
                                                + " not found."
                                )
                        );
        categoryRepository.deleteById(id);
    }
}