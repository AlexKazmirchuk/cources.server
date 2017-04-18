package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.AuthorizationCacheServiceImpl;
import com.softgroup.authorization.impl.handler.LoginRequestHandler;
import com.softgroup.authorization.impl.handler.RegisterRequestHandler;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.impl.TokenServiceImpl;
import com.softgroup.common.model.mapper.api.ModelMapper;
import com.softgroup.common.model.mapper.impl.ModelMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AlexKazmirchuk
 * @since 12.04.17.
 */

@Configuration
public class AuthorizationAppCfgIT {

    @Bean
    public LoginRequestHandler getLoginRequestHandler(){
        return new LoginRequestHandler();
    }

    @Bean
    public RegisterRequestHandler getRegisterRequestHandler(){
        return new RegisterRequestHandler();
    }

    @Bean
    public TokenService getTokenService(){
        return new TokenServiceImpl();
    }

    @Bean
    public DataMapper getDataMapper(){
        return new JacksonDataMapper();
    }

    @Bean
    public AuthorizationCacheService cacheService(){
        return new AuthorizationCacheServiceImpl();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapperImpl();
    }

}
