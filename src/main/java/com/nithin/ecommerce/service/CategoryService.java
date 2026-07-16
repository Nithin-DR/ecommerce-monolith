package com.nithin.ecommerce.service;

import com.nithin.ecommerce.dto.CategoryRequest;
import com.nithin.ecommerce.dto.CategoryResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);

    List<CategoryResponse> findAll();

    CategoryResponse findById(Long id);

    CategoryResponse updateCategory(Long id,CategoryRequest request);

    void deleteCategory(Long id);
}