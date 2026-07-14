package com.nithin.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//The DTOs are for communication.
// This class Represents incoming API data
public class CategoryRequest {

    //Here all the validations annotations are take cared by Spring Validations.
    // By this we can Secure our API's if validation fails it throws error and won't reach the request to Controller.
    // Stop Exposing Entity class to Clients.
    @Size(max = 100)
    private String name;

    @Size(max = 500)
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