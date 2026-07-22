package com.nithin.ecommerce.service;

import com.nithin.ecommerce.dto.ProductRequest;
import com.nithin.ecommerce.dto.ProductResponse;
import com.nithin.ecommerce.entity.Category;
import com.nithin.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    List<ProductResponse> getAllProducts();
}
