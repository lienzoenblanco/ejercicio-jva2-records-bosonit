package com.example.ej2crud.application.exceptions;

import com.example.ej2crud.infraestructure.dto.output.OutputCustomErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<OutputCustomErrorDto> ResponseEntityExceptionHandler(NotFoundException exception) {
        OutputCustomErrorDto error = new OutputCustomErrorDto(new Date(), HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<OutputCustomErrorDto>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableException.class)
    public final ResponseEntity<OutputCustomErrorDto>  ResponseEntityExceptionHandler (UnprocessableException exception){
        OutputCustomErrorDto error = new OutputCustomErrorDto(new Date(), HttpStatus.UNPROCESSABLE_ENTITY.value(), exception.getMessage());
        return new ResponseEntity<OutputCustomErrorDto>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
