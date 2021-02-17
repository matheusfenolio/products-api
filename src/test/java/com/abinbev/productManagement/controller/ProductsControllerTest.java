package com.abinbev.productManagement.controller;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.mocks.ProductMocks;
import com.abinbev.productManagement.models.Product;
import com.abinbev.productManagement.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductsControllerTest {

    @InjectMocks
    private ProductsController productsController;

    @Mock
    private ProductService productService;

    @Test
    public void testAddProductByName() throws Exception {
        Product expectedProduct = ProductMocks.createProduct();
        ProductParametersDto productParametersDto = ProductMocks.createProductParametersDto();
        when(productService.insertProductInDatabase(productParametersDto)).thenReturn(expectedProduct);
        ResponseEntity<Product> responseProduct = productsController.addProduct(productParametersDto);
        Assert.assertEquals(ResponseEntity.status(HttpStatus.OK).body(expectedProduct), responseProduct);
    }

    @Test
    public void testUpdateProductByName() throws Exception {
        Product expectedProduct = ProductMocks.createProduct();
        ProductNameUpdateParameterDto productNameUpdateParameterDto = ProductMocks.createProductNameUpdateParameterDto();
        when(productService.updateProductInDatabase("a1b2c3d4", productNameUpdateParameterDto)).thenReturn(expectedProduct);
        ResponseEntity<Product> responseProduct = productsController.updateProductNameById("a1b2c3d4" ,productNameUpdateParameterDto);
        Assert.assertEquals(ResponseEntity.status(HttpStatus.OK).body(expectedProduct), responseProduct);
    }

    @Test
    public void testDeleteProductByName() {
        Product expectedProduct = ProductMocks.createProduct();
        ProductParametersDto productParametersDto = ProductMocks.createProductParametersDto();
        when(productService.deleteProductInDatabase("a1b2c3d4")).thenReturn(expectedProduct);
        ResponseEntity<Product> responseProduct = productsController.deleteProductById("a1b2c3d4");
        Assert.assertEquals(ResponseEntity.status(HttpStatus.OK).body(expectedProduct), responseProduct);
    }

    @Test
    public void testGetProductById() {
        Product expectedProduct = ProductMocks.createProduct();
        when(productService.findProductInDatabaseById("a1b2c3d4")).thenReturn(expectedProduct);
        ResponseEntity<Product> responseProduct = productsController.getProductById("a1b2c3d4");
        Assert.assertEquals(ResponseEntity.status(HttpStatus.OK).body(expectedProduct), responseProduct);
    }

    @Test
    public void testGetProductByName() {
        Product expectedProduct = ProductMocks.createProduct();
        when(productService.findProductInDatabaseByName("a1b2c3d4")).thenReturn(expectedProduct);
        ResponseEntity<Product> responseProduct = productsController.getProductByName("a1b2c3d4");
        Assert.assertEquals(ResponseEntity.status(HttpStatus.OK).body(expectedProduct), responseProduct);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> expectedProduct = List.of(ProductMocks.createProduct());
        when(productService.findAllProductsInDatabase()).thenReturn(expectedProduct);
        ResponseEntity<List<Product>> responseProduct = productsController.getAllProducts();
        Assert.assertEquals(ResponseEntity.status(HttpStatus.OK).body(expectedProduct), responseProduct);
    }
}
