package com.fiprojecta.projectaspringboot.exception.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = { CustomNotFoundException.class })
    public ResponseEntity<Object> handleCloudVendorNotFoundException(
            CustomNotFoundException customNotFoundException) {
                
        CustomException cloudVendorException = new CustomException(
                customNotFoundException.getMessage(),
                customNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}
