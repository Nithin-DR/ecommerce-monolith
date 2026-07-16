package com.nithin.ecommerce.exception;

public class CategoryNotFoundException
        extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }

}

