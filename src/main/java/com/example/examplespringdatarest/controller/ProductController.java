package com.example.examplespringdatarest.controller;

import com.example.examplespringdatarest.entity.Product;
import com.example.examplespringdatarest.service.ProductService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    public Iterable list(Model model) {
        Iterable productList = productService.listAllProducts();
        return productList;
    }

    /**
     * 创建产品
     *
     * @param product
     * @return
     */
    @PostMapping(value = "/add")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    /**
     * 更新产品信息. 使用HTTP的PUT方法, 路径为 /product/{id}, 接收两个参数, 分别是产品ID, 以及产品的信息
     *
     * @param id
     * @param product
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) {
        // 通过产品ID, 从产品服务获取哦一个产品对象
        Product storedProduct = productService.getProductById(id);
        // 从Http请求体(Request Body) 获取产品对象数据, 并更新产品实体属性
        storedProduct.setDescription(product.getDescription());
        storedProduct.setImageUrl(product.getImageUrl());
        storedProduct.setPrice(product.getPrice());
        // 保存
        productService.saveProduct(storedProduct);
        // 返回
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    /**
     * 删除产品
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity("Product delete successfully", HttpStatus.OK);
    }
}
