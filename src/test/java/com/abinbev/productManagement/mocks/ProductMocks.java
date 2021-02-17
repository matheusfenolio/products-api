package com.abinbev.productManagement.mocks;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.models.Product;

public class ProductMocks {
    public static ProductParametersDto createProductParametersDto(){
        ProductParametersDto productParametersDto = new ProductParametersDto();

        productParametersDto.setName("Skol");
        productParametersDto.setDescription("Cerveja");
        productParametersDto.setPrice(2.5);

        return productParametersDto;
    }

    public static ProductNameUpdateParameterDto createProductNameUpdateParameterDto(){
        ProductNameUpdateParameterDto productNameUpdateParameterDto = new ProductNameUpdateParameterDto();

        productNameUpdateParameterDto.setProductName("Brahma");

        return productNameUpdateParameterDto;
    }

    public static Product createProduct(){
        Product product = new Product();

        product.setId("a1b2c3d4");
        product.setName("Skol");
        product.setDescription("Cerveja");
        product.setPrice(2.5);

        return product;
    }
}
