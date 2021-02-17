package com.abinbev.productManagement.controller;

import com.abinbev.productManagement.exceptions.ProductNameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductsControllerExceptionHandler {

    @ExceptionHandler(ProductNameAlreadyExistsException.class)
    public ResponseEntity handleAircraftNotFoundException(ProductNameAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.toString());
    }
}
