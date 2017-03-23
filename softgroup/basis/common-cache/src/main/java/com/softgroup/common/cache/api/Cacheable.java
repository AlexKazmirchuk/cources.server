package com.softgroup.common.cache.api;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */

public interface Cacheable<T> {

    void save(String key, T value);

    T loadFromSource(String key);

    T get(String key);
}
