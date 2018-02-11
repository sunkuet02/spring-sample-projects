package com.sunkuet02.datamongojpa.dao;

import com.sunkuet02.datamongojpa.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by sun on 8/17/17.
 */
public interface ProductRepository extends MongoRepository<Product, Long> {
}
