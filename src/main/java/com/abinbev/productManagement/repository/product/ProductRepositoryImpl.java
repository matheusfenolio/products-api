package com.abinbev.productManagement.repository.product;

import com.abinbev.productManagement.models.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static final Log log = LogFactory.getLog(ProductRepositoryImpl.class);

    @Autowired
    private MongoOperations mongoOps;

    public Product insert(Product product) {
        return mongoOps.insert(product);
    }

    public Product updateName(String id, String name) {
        Product productToBeUpdated = findProductById(id);

        if (productToBeUpdated != null) {
            productToBeUpdated.setName(name);
            return mongoOps.save(productToBeUpdated);
        } else {
            return null;
        }

    }

    public Product delete(String id) {
        Product product = mongoOps.findOne(new Query(where("id").is(id)), Product.class);
        if (product != null) {
            mongoOps.remove(product);
        }

        return product;
    }

    public Product findProductById(String id) {
        return mongoOps.findOne(new Query(where("id").is(id)), Product.class);
    }

    public Product findProductByName(String name) {
        return mongoOps.findOne(new Query(where("name").is(name)), Product.class);
    }

    @Override
    public List<Product> findAllProducts() {
        return mongoOps.findAll(Product.class);
    }

    public Boolean checkIfThereIsAProductWithSameName(String name) {
        return findProductByName(name) != null;
    }
}
