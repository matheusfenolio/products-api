package com.abinbev.productManagement.repository;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.mocks.ProductMocks;
import com.abinbev.productManagement.models.Product;
import com.abinbev.productManagement.repository.product.ProductRepositoryImpl;
import com.abinbev.productManagement.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductsRepositoryImplTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepositoryImpl productRepository;

    @Captor
    private ArgumentCaptor<Product> captorProduct;

    @Test
    public void testInsert() throws Exception {
        ProductParametersDto productParametersDto = ProductMocks.createProductParametersDto();

        productService.insertProductInDatabase(productParametersDto);

        Mockito.verify(productRepository, Mockito.times(1)).insert(captorProduct.capture());
    }

    @Test
    public void testUpdateName() throws Exception {
        ProductNameUpdateParameterDto productNameUpdateParameterDto = ProductMocks.createProductNameUpdateParameterDto();

        productService.updateProductInDatabase("a1b2c3d4", productNameUpdateParameterDto);

        Mockito.verify(productRepository, Mockito.times(1)).updateName("a1b2c3d4", productNameUpdateParameterDto.getProductName());
    }

    @Test
    public void testDelete(){
        productService.deleteProductInDatabase("a1b2c3d4");

        Mockito.verify(productRepository, Mockito.times(1)).delete("a1b2c3d4");
    }

    @Test
    public void testFindProductById(){
        productService.findProductInDatabaseById("a1b2c3d4");

        Mockito.verify(productRepository, Mockito.times(1)).findProductById("a1b2c3d4");
    }

    @Test
    public void testFindProductByName(){
        productService.findProductInDatabaseByName("Skol");

        Mockito.verify(productRepository, Mockito.times(1)).findProductByName("Skol");
    }

    @Test
    public void findAllProducts(){
        productService.findAllProductsInDatabase();

        Mockito.verify(productRepository, Mockito.times(1)).findAllProducts();
    }
}
