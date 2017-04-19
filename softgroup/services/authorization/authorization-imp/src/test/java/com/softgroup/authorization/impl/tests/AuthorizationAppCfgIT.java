package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.handler.LoginRequestHandler;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.impl.TokenServiceImpl;
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
    public TokenService getTokenService(){
        return new TokenServiceImpl();
    }

    @Bean
    public DataMapper getDataMapper(){
        return new JacksonDataMapper();
    }

}
