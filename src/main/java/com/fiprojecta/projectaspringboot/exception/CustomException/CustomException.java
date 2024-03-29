package com.fiprojecta.projectaspringboot.exception.CustomException;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomException {
    private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;
}
