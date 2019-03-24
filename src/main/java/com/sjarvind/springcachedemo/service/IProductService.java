package com.sjarvind.springcachedemo.service;

import com.sjarvind.springcachedemo.model.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
