package com.nithin.ecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductRequest {

    @NotBlank(message = "Product name can not be blank")
    @Size(max=100, message = "Product name can not exceed 100 characters")
    private String name;

    @Size(max=500, message = "Product description can not exceed 500 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Stock is required")
    @PositiveOrZero(message = "Stock cannot be negative")
    private Integer stock;

    @NotNull(message = "Category is required")
    private Long categoryId;
}
