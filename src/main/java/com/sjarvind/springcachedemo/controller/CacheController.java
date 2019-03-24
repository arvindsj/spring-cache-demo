package com.sjarvind.springcachedemo.controller;

import com.sjarvind.springcachedemo.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CacheController {

    @Autowired
    private ICacheService cacheService;

    @GetMapping("cache/viewProductCache")
    public Map<Object, Object> viewProductCache() {
        return cacheService.viewProductCache();
    }

}
