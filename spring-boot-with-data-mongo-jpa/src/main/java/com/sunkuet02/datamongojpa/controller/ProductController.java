package com.sunkuet02.datamongojpa.controller;

import com.sunkuet02.datamongojpa.model.Product;
import com.sunkuet02.datamongojpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProduct();
    }

    @PostMapping("/products")
    public long insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id) {
        return productService.getProductsById(id);
    }
}
