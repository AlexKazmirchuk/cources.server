package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.handler.LoginRequestHandler;
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

}
