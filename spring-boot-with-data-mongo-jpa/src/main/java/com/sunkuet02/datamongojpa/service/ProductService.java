package com.sunkuet02.datamongojpa.service;

import com.sunkuet02.datamongojpa.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product getProductsById(Long id);

    long insertProduct(Product product);
}
