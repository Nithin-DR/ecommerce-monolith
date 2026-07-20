package com.nithin.ecommerce.exception;

import com.nithin.ecommerce.common.dto.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

//cross-cutting concern
@RestControllerAdvice // During Start UP Spring Scans it and registers it as a global exception handler.
// It handles the exceptions from all the Controllers instead of writing try and catch we write it in one class and throw them
public class GlobalExceptionHandler {

    private ApiErrorResponse buildErrorResponse(HttpStatus status, String message, HttpServletRequest request){

        ApiErrorResponse response =new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(status.value());
        response.setMessage(message);
        response.setError(status.getReasonPhrase());
        response.setPath(request.getRequestURI());

        return response;

    }


    @ExceptionHandler(CategoryAlreadyExistsException.class) //  when this Exception occurs then execute this method.
    // here we use .class, the class which is derived for exception.
    public ResponseEntity<ApiErrorResponse> handleCategoryAlreadyExists(
            CategoryAlreadyExistsException ex, HttpServletRequest request) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(buildErrorResponse(HttpStatus.CONFLICT,ex.getMessage(), request));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCategoryNotFound(CategoryNotFoundException ex, HttpServletRequest request){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage(), request));
    }


}