package com.example.ej2crud.application.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private Boolean success;
    private String message;

    public ResponseDto(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
