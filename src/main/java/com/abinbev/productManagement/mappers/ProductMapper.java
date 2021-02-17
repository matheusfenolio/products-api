package com.abinbev.productManagement.mappers;

import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.models.Product;

public class ProductMapper {
    public static Product convertProductParametersDtoToProduct(ProductParametersDto productParametersDto){
        Product product = new Product();
        product.setName(productParametersDto.getName());
        product.setDescription(productParametersDto.getDescription());
        product.setPrice(productParametersDto.getPrice());

        return product;
    }
}
