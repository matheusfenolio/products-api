package com.abinbev.productManagement.controller;

import com.abinbev.productManagement.exceptions.ProductNameAlreadyExistsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProductsControllerExceptionHandlerTest {
    private ProductsControllerExceptionHandler handler;

    @Before
    public void setup() {
        handler = new ProductsControllerExceptionHandler();
    }

    @Test
    public void testHandleAircraftNotFoundException() throws Exception {
        final ResponseEntity<String> responseEntity = handler.handleProductNameAlreadyExistsException(new ProductNameAlreadyExistsException(""));
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
    }

}
