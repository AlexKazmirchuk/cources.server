package com.softgroup.common.cache.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.softgroup.common.cache.api.Cacheable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */

public abstract class CacheService<T> implements Cacheable<T> {

    public static final int SIZE = 100;
    public static final int DURATION = 30;

    private LoadingCache<String,T> cache;

    {
        cache = CacheBuilder.newBuilder()
                .maximumSize(SIZE)
                .expireAfterAccess(DURATION, TimeUnit.MINUTES)
                .build(new CacheLoader<String, T>() {
                    @Override
                    public T load(String key) throws Exception {
                        return loadFromSource(key);
                    }
                });
    }

    @Override
    public void save(String key, T value) {
        if (key != null && value != null){
            cache.put(key,value);
        }
    }

    @Override
    public abstract T loadFromSource(String key);

    @Override
    public  T get(String key){
        if (key == null){
            return null;
        }
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            return null;
        } catch (CacheLoader.InvalidCacheLoadException ex){
            return null;
        }
    }
}
