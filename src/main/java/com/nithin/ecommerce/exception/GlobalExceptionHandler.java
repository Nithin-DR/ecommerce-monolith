package com.nithin.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.Map;

//cross-cutting concern
@RestControllerAdvice // During Start UP Spring Scans it and registers it as a global exception handler.
// It handles the exceptions from all the Controllers instead of writing try and catch we write it in one class and throw them
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryAlreadyExistsException.class) //  when this Exception occurs then execute this method.
    // here we use .class, the class which is derived for exception.
    public ResponseEntity<Map<String, Object>> handleCategoryAlreadyExists(
            CategoryAlreadyExistsException ex) {

        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.CONFLICT.value(),
                "message", ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, Object>>  handleCategoryNotFound(CategoryNotFoundException ex){
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.NOT_FOUND.value(),
                "message", ex.getMessage()

        );


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }


}