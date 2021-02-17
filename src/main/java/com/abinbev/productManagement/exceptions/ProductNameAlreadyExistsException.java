package com.abinbev.productManagement.exceptions;

public class ProductNameAlreadyExistsException extends Exception {
    public ProductNameAlreadyExistsException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "{\"error\":\"" + getMessage() + "\"}";
    }
}
