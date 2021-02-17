package com.abinbev.productManagement.controller;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.models.Product;
import com.abinbev.productManagement.services.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping()
    @ApiOperation(value = "Add new product")
    public ResponseEntity<Product> addProduct(@Validated @RequestBody ProductParametersDto productParametersDto) throws Exception {
        Product product = new Product();
        product = productService.insertProductInDatabase(productParametersDto);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update product")
    public ResponseEntity<Product> updateProductNameById(@PathVariable(value = "id") String id, @Validated @RequestBody ProductNameUpdateParameterDto productNameUpdateParameterDto) throws Exception {
        Product product = productService.updateProductInDatabase(id, productNameUpdateParameterDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete product")
    public ResponseEntity<Product> deleteProductById(@PathVariable(value = "id") String id) {
        Product product = productService.deleteProductInDatabase(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get product by id")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String id) {
        Product product = productService.findProductInDatabaseById(id);
        return ResponseEntity.status(product == null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(product);
    }

    @GetMapping("/byName/{name}")
    @ApiOperation(value = "Find product by name")
    public ResponseEntity<Product> getProductByName(@PathVariable(value = "name") String name) {
        Product product = productService.findProductInDatabaseByName(name);
        return ResponseEntity.status(product == null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(product);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProductsInDatabase();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
