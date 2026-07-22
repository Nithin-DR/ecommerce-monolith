package com.nithin.ecommerce.common.dto;

import jdk.jfr.DataAmount;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    private Map<String, String> errors;




}
