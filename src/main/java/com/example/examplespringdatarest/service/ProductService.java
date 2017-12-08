package com.example.examplespringdatarest.service;

import com.example.examplespringdatarest.entity.Product;

public interface ProductService {
    /**
     * 获取产品列表
     * @return
     */
    Iterable<Product> listAllProducts();

    /**
     * 获取单个产品
     * @param id
     * @return
     */
    Product getProductById(Long id);

    /**
     * 创建一个产品
     * @param product
     * @return
     */
    Product saveProduct(Product product);

    /**
     * 删除一个产品: 按ID
     * @param id
     */
    void deleteProduct(Long id);

    /**
     * 删除一个产品: 按对象实例
     * @param product
     */
    void deleteProduct(Product product);
}
