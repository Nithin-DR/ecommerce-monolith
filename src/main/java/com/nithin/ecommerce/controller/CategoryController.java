package com.nithin.ecommerce.controller;

import com.nithin.ecommerce.dto.CategoryRequest;
import com.nithin.ecommerce.dto.CategoryResponse;
import com.nithin.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController // = @Controller+ @ResponseBody - so we don't need to explicitly write @ResponseBody while returning to JSON
@RequestMapping("/api/v1/categories")// instead of writing the path to all the api's we write it in RequestMapping, so no need to repeat it again in all the API.
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
   // @ResponseStatus(HttpStatus.CREATED) -- can write like this, when no ResponseEntity
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(request));

    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id,@RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.updateCategory(id,request));
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }


}