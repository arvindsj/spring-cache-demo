package com.sjarvind.springcachedemo.service;

import com.sjarvind.springcachedemo.model.Product;
import com.sjarvind.springcachedemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void initData() {
        productRepository.saveAll(initProducts());
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Cacheable("productCache")
    public Product getProductById(final Long id) {
        return productRepository.findById(id).orElse(null);
    }

    private List<Product> initProducts() {
        return Arrays.asList(
                new Product(1l, "Wine", "WNE10"),
                new Product(2l, "Apple", "APL11"),
                new Product(3l, "Grapes", "GPE12"),
                new Product(4l, "Dragon Fruit", "DF13"),
                new Product(5l, "Guava", "GVA14"),
                new Product(6l, "Plums", "PLM15"),
                new Product(7l, "Kale", "KLE16"),
                new Product(8l, "Olive Oil", "OLL17"),
                new Product(9l, "Paper Towels", "PTS18"),
                new Product(10l, "Tylanol", "TYL19")
        );
    }
}
