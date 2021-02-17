package com.abinbev.productManagement.services;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.exceptions.ProductNameAlreadyExistsException;
import com.abinbev.productManagement.mappers.ProductMapper;
import com.abinbev.productManagement.models.Product;
import com.abinbev.productManagement.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private IProductRepository iProductRepository;

    public Product insertProductInDatabase(ProductParametersDto productParametersDto) throws ProductNameAlreadyExistsException {
        validateProductNameInDatabase(productParametersDto.getName());
        Product product = ProductMapper.convertProductParametersDtoToProduct(productParametersDto);
        return iProductRepository.insert(product);
    }

    public Product updateProductInDatabase(String id, ProductNameUpdateParameterDto productNameUpdateParameterDto) throws Exception {
        validateProductNameInDatabase(productNameUpdateParameterDto.getProductName());
        return iProductRepository.updateName(id, productNameUpdateParameterDto.getProductName());
    }

    public Product deleteProductInDatabase(String id){
        return iProductRepository.delete(id);
    }

    public Product findProductInDatabaseById(String id){
        return iProductRepository.findProductById(id);
    }

    public Product findProductInDatabaseByName(String name){
        return iProductRepository.findProductByName(name);
    }

    public List<Product> findAllProductsInDatabase(){
        List<Product> products = iProductRepository.findAllProducts();
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    private void validateProductNameInDatabase(String name) throws ProductNameAlreadyExistsException {
        boolean nameIsntAvaible = iProductRepository.checkIfThereIsAProductWithSameName(name);
        if(nameIsntAvaible){
            throw new ProductNameAlreadyExistsException("Product name " + name +  " already in use.");
        }
    }
}
