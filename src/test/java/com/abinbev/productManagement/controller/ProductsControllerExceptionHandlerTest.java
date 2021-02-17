package com.abinbev.productManagement.controller;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.mocks.ProductMocks;
import com.abinbev.productManagement.models.Product;
import com.abinbev.productManagement.repository.product.IProductRepository;
import com.abinbev.productManagement.services.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductsControllerExceptionHandlerTest {
    private ProductsControllerExceptionHandler handler;

    @Before
    public void setup() {
        handler = new ProductsControllerExceptionHandler();
    }

    @Test
    public void testHandleAircraftNotFoundException() throws Exception {
        final ResponseEntity<String> responseEntity = handler.handleProductNameAlreadyExistsException(new ProductsControllerExceptionHandler());
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
    }

}
