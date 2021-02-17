package com.abinbev.productManagement.repository.product;

import com.abinbev.productManagement.models.Product;

import java.util.List;

public interface IProductRepository {
    Product insert(Product product);

    Product updateName(String id, String name);

    Product delete(String id);

    Product findProductById(String id);

    Product findProductByName(String name);

    List<Product> findAllProducts();

    Boolean checkIfThereIsAProductWithSameName(String name);
}
