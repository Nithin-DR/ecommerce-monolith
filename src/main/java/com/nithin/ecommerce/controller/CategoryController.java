package com.nithin.ecommerce.controller;

import com.nithin.ecommerce.dto.CategoryRequest;
import com.nithin.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")// instead of writing the url to all the api's we write it in RequestMapping, son need to repeat it again.
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@Valid @RequestBody CategoryRequest request) {

        categoryService.createCategory(request);

    }
}