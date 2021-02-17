package com.abinbev.productManagement.services;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.exceptions.ProductNameAlreadyExistsException;
import com.abinbev.productManagement.mappers.ProductMapper;
import com.abinbev.productManagement.models.Product;
import com.abinbev.productManagement.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository iProductRepository;

    public Product insertProductInDatabase(ProductParametersDto productParametersDto) throws Exception {

        boolean nameIsntAvaible = iProductRepository.checkIfThereIsAProductWithSameName(productParametersDto.getName());
        if(nameIsntAvaible){
            throw new ProductNameAlreadyExistsException("Product name " + productParametersDto.getName() +  " already in use.");
        }else{
            Product product = ProductMapper.convertProductParametersDtoToProduct(productParametersDto);
            return iProductRepository.insert(product);
        }
    }

    public Product updateProductInDatabase(String id, ProductNameUpdateParameterDto productNameUpdateParameterDto) throws Exception {
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
        return iProductRepository.findAllProducts();
    }
}
