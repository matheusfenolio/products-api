package com.abinbev.productManagement.controller;

import com.abinbev.productManagement.exceptions.ProductNameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductsControllerExceptionHandler {

    @ExceptionHandler(ProductNameAlreadyExistsException.class)
    public ResponseEntity handleProductNameAlreadyExistsException(ProductNameAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.toString());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.toString());
    }
}
