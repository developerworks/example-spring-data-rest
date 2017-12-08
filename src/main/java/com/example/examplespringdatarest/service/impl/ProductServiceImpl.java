package com.example.examplespringdatarest.service.impl;

import com.example.examplespringdatarest.entity.Product;
import com.example.examplespringdatarest.repository.ProductRepository;
import com.example.examplespringdatarest.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductRepository productRepository;

    public Iterable listAllProducts() {
        logger.debug("List all products");
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        logger.debug("Save a product instance");
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        logger.debug("Get product by id");
        return productRepository.findOne(id);
    }

    @Override
    public void deleteProduct(Long id) {
        logger.debug("Delete a product by id");
        productRepository.delete(id);
    }

    @Override
    public void deleteProduct(Product product) {
        logger.debug("Delete a product by a instance");
        productRepository.delete(product);
    }
}
