package com.abinbev.productManagement.controller;

import com.abinbev.productManagement.dto.ProductNameUpdateParameterDto;
import com.abinbev.productManagement.dto.ProductParametersDto;
import com.abinbev.productManagement.models.Product;
import com.abinbev.productManagement.repository.product.IProductRepository;
import com.abinbev.productManagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/1/products")
public class ProductsController {


    @Autowired
    private ProductService productService;

    @PostMapping()
    @ApiOperation(value = "Add new product")
    public ResponseEntity<Product> addProductByName(@RequestBody ProductParametersDto productParametersDto) throws Exception {
        Product product = new Product();
        product = productService.insertProductInDatabase(productParametersDto);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update product")
    public ResponseEntity<Product> updateProductByName(@PathVariable(value = "id") String id, @RequestBody ProductNameUpdateParameterDto productNameUpdateParameterDto) throws Exception {
        Product product = productService.updateProductInDatabase(id, productNameUpdateParameterDto);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete product")
    public ResponseEntity<Product> deleteProductByName(@PathVariable(value = "id") String id){
        Product product = productService.deleteProductInDatabase(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get product by id")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String id){
        Product product = productService.findProductInDatabaseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/byName/{name}")
    @ApiOperation(value = "Find product by name")
    public ResponseEntity<Product> getProductByName(@PathVariable(value = "name") String name){
        Product product = productService.findProductInDatabaseByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProductsInDatabase();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
