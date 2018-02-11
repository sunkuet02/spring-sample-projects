package com.sunkuet02.datamongojpa.service;

import com.sunkuet02.datamongojpa.dao.AutoGenSequenceDao;
import com.sunkuet02.datamongojpa.dao.ProductRepository;
import com.sunkuet02.datamongojpa.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpls implements ProductService {

    private final static Logger logger = Logger.getLogger(ProductServiceImpls.class);

    private final static String AUTOGEN_SEQUENCE_NAME = "product_seq";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AutoGenSequenceDao sequenceDao;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductsById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public long insertProduct(Product product) {
        if(product.getId() != null) return -1;
        product.setId(sequenceDao.getNextSequenceId(AUTOGEN_SEQUENCE_NAME));
        productRepository.save(product);

        return product.getId();
    }
}
