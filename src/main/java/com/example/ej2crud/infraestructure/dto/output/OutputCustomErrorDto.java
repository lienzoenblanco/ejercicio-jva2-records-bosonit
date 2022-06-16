package com.example.ej2crud.infraestructure.dto.output;

import lombok.Data;

import java.util.Date;

@Data
public class OutputCustomErrorDto {
    private Date timestamp;
    private int HttpCode;
    private String errorMessage;

    public OutputCustomErrorDto(Date timestamp, int httpCode, String errorMessage) {
        this.timestamp = timestamp;
        HttpCode = httpCode;
        this.errorMessage = errorMessage;
    }
}
