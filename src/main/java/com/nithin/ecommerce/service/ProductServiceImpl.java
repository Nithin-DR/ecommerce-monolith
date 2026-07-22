package com.nithin.ecommerce.service;

import com.nithin.ecommerce.dto.CategorySummary;
import com.nithin.ecommerce.dto.ProductRequest;
import com.nithin.ecommerce.dto.ProductResponse;
import com.nithin.ecommerce.entity.Category;
import com.nithin.ecommerce.entity.Product;
import com.nithin.ecommerce.exception.CategoryAlreadyExistsException;
import com.nithin.ecommerce.exception.CategoryNotFoundException;
import com.nithin.ecommerce.exception.ProductAlreadyExistsException;
import com.nithin.ecommerce.repository.CategoryRepository;
import com.nithin.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {

        String productName = request.getName().trim();

        if (productRepository.existsByName(productName)) {
            throw new ProductAlreadyExistsException(
                    "Product '" + productName + "' already exists."
            );
        }

        Category category =
                categoryRepository.findById(request.getCategoryId())
                        .orElseThrow(() -> new CategoryNotFoundException("Category with id "+ request.getCategoryId()+ " not found."));

        Product product=new Product();

        product.setName(productName); // save the filtered one if the condition satisfied.
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setActive(true);
        product.setCreatedAt(LocalDateTime.now());
        product.setCategory(category);

        Product savedProduct =productRepository.save(product);



        return mapToResponse(savedProduct);
    }

    private ProductResponse mapToResponse(Product product) {

        CategorySummary categorySummary = new CategorySummary();
        categorySummary.setId(product.getCategory().getId());
        categorySummary.setName(product.getCategory().getName());

        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setActive(product.getActive());
        response.setCategory(categorySummary);

        return response;
    }

    @Override
    public List<ProductResponse> getAllProducts(){
            List<Product> products=productRepository.findAll();// first we get it
            List<ProductResponse> responses= new ArrayList<>();// then we want to assign here



            for (Product product : products) {
                responses.add(mapToResponse(product));
            }

        return responses;
    }
}
