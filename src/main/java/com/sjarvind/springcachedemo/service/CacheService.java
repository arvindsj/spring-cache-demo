package com.sjarvind.springcachedemo.service;

import net.sf.ehcache.Ehcache;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CacheService implements ICacheService {

    CacheManager cacheManager;

    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public Map<Object, Object> viewProductCache() {
        Map<Object, Object> map = null;

        Cache cache = cacheManager.getCache("productCache");
        Object nativeCache = cache.getNativeCache();

        if (nativeCache instanceof Ehcache) {
            Ehcache ehCache = (Ehcache) nativeCache;
            List<Object> keyList = ehCache.getKeys();
            if (keyList != null && !keyList.isEmpty()) {
                map = keyList.stream()
                        .map(key -> ehCache.get(key))
                        .collect(Collectors.toMap(e -> e.getObjectKey(), e -> e.getObjectValue()));
            }
        }
        return map;
    }
}
