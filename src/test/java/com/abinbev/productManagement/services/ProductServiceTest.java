package com.abinbev.productManagement.services;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.exceptions.ProductNameAlreadyExistsException;
import com.abinbev.productManagement.mocks.ProductMocks;
import com.abinbev.productManagement.models.Product;
import com.abinbev.productManagement.repository.product.IProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private IProductRepository iProductRepository;

    @Test
    public void testInsertProductInDatabase() throws Exception {
        Product expectedProduct = ProductMocks.createProduct();
        ProductParametersDto productParametersDto = ProductMocks.createProductParametersDto();

        when(iProductRepository.insert(any(Product.class))).thenReturn(expectedProduct);

        Product actualProduct = productService.insertProductInDatabase(productParametersDto);
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testUpdateProductInDatabase() throws Exception {
        Product expectedProduct = ProductMocks.createProduct();
        ProductNameUpdateParameterDto productNameUpdateParameterDto = ProductMocks.createProductNameUpdateParameterDto();

        when(iProductRepository.updateName("a1b2c3d4", productNameUpdateParameterDto.getProductName())).thenReturn(expectedProduct);

        Product actualProduct = productService.updateProductInDatabase("a1b2c3d4", productNameUpdateParameterDto);
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testDeleteProductInDatabase() {
        Product expectedProduct = ProductMocks.createProduct();
        when(iProductRepository.delete("a1b2c3d4")).thenReturn(expectedProduct);
        Product actualProduct = productService.deleteProductInDatabase("a1b2c3d4");
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testFindProductInDatabaseById() {
        Product expectedProduct = ProductMocks.createProduct();
        when(iProductRepository.findProductById("a1b2c3d4")).thenReturn(expectedProduct);
        Product actualProduct = productService.findProductInDatabaseById("a1b2c3d4");
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testFindProductInDatabaseByName() {
        Product expectedProduct = ProductMocks.createProduct();
        when(iProductRepository.findProductByName(anyString())).thenReturn(expectedProduct);
        Product actualProduct = productService.findProductInDatabaseByName(expectedProduct.getName());
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testFindAllProductsInDatabase() {
        List<Product> expectedProduct = List.of(ProductMocks.createProduct());
        when(iProductRepository.findAllProducts()).thenReturn(expectedProduct);
        List<Product> actualProduct = productService.findAllProductsInDatabase();
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test(expected = ProductNameAlreadyExistsException.class)
    public void testInsertProductInDatabaseException() throws Exception {
        Product expectedProduct = ProductMocks.createProduct();
        ProductParametersDto productParametersDto = ProductMocks.createProductParametersDto();
        when(iProductRepository.checkIfThereIsAProductWithSameName(productParametersDto.getName())).thenReturn(true);
        Product actualProduct = productService.insertProductInDatabase(productParametersDto);
    }

    @Test(expected = ProductNameAlreadyExistsException.class)
    public void testUpdateProductInDatabaseException() throws Exception {
        Product expectedProduct = ProductMocks.createProduct();
        ProductNameUpdateParameterDto productNameUpdateParameterDto = ProductMocks.createProductNameUpdateParameterDto();
        when(iProductRepository.checkIfThereIsAProductWithSameName(productNameUpdateParameterDto.getProductName())).thenReturn(true);
        Product actualProduct = productService.updateProductInDatabase("a1b2c3d4", productNameUpdateParameterDto);
    }


}
