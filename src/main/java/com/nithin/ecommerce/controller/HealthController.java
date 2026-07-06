package com.nithin.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController      //--- This class can handle HTTP requests.
public class HealthController {

    @GetMapping("/api/v1/health")
    public Map<String, Object> health() {

        return Map.of(
                "status", "UP",
                "application", "E-Commerce Backend",
                "timestamp", LocalDateTime.now()
        );

    }

}