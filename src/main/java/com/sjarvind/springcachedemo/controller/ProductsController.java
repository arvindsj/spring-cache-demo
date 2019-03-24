package com.sjarvind.springcachedemo.controller;

import com.sjarvind.springcachedemo.model.Product;
import com.sjarvind.springcachedemo.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    Logger logger = LoggerFactory.getLogger(ProductsController.class);


    @Autowired
    private IProductService productService;

    @GetMapping(value = "/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/products/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id") final Long productId) {
        StopWatch watch = new StopWatch("productCacheTimer");
        watch.start();
        Product product = productService.getProductById(productId);
        watch.stop();
        logger.info(watch.prettyPrint());
        return product;
    }
}
