package com.nithin.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//The DTOs are for communication.
// This class Represents incoming API data
public class CategoryRequest {

    //Here all the validations annotations are take cared by Spring Validations.
    // By this we can Secure our API's if validation fails it throws error and won't reach the request to Controller.
    // Stop Exposing Entity class to Clients.
    @NotBlank(message = "Category name is required.")
    @Size(max = 100,message = "Category name cannot exceed 100 characters.")
    private String name;

    //Annotations are instructions
    // For this validation annotation, The Spring MVC reads and delegates it to Hibernate Validator, Spring MVC itself doesn't validate.
    // (Just like delegating @RequestBody to Jackson: To  deserialize JSON to Java Objects)
    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

    public String getName() {
               return name;
    }

    public void setName(String name) {
                this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}