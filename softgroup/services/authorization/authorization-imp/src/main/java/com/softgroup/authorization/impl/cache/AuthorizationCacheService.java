package com.softgroup.authorization.impl.cache;

import com.softgroup.common.cache.impl.CacheService;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */
@Service
public class AuthorizationCacheService extends CacheService<RegistrationCacheData> {

    @Override
    public RegistrationCacheData loadFromSource(String key) {
        return null;
    }
}
