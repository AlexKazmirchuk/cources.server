package com.softgroup.ws.frontend.configuration;

import com.softgroup.ws.frontend.TokenHandshakeInterceptor;
import com.softgroup.ws.frontend.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author AlexKazmirchuk
 * @since 14.04.17.
 */

@Configuration
@EnableWebSocket
@ComponentScan(basePackages = {"com.softgroup.ws.frontend"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class))
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Autowired
    private WebSocketHandler webSocketHandler;

    @Autowired
    private TokenHandshakeInterceptor tokenHandshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/api/private")
                .addInterceptors(tokenHandshakeInterceptor)
                .setAllowedOrigins("*");
    }

}
