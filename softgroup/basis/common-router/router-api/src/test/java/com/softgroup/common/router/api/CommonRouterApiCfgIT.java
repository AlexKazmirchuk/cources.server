package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author AlexKazmirchuk
 * @since 10.04.17.
 */

@Configuration
public class CommonRouterApiCfgIT {

    @Bean
    public List<RequestHandler> getRequestHandlerList(){
        RequestHandler handlerOne = mock(RequestHandler.class);
        when(handlerOne.getName()).thenReturn("test_command_one");
        RequestHandler handlerTwo = mock(RequestHandler.class);
        when(handlerTwo.getName()).thenReturn("test_command_two");
        List<RequestHandler> handlers = new ArrayList<>();
        handlers.add(handlerOne);
        handlers.add(handlerTwo);
        return handlers;
    }

    @Bean
    public List<RouterHandler> getRouterHandlerList(){
        RouterHandler handlerOne = mock(RouterHandler.class);
        when(handlerOne.getName()).thenReturn("test_type_one");
        RouterHandler handlerTwo = mock(RouterHandler.class);
        when(handlerTwo.getName()).thenReturn("test_type_two");
        List<RouterHandler> handlers = new ArrayList<>();
        handlers.add(handlerOne);
        handlers.add(handlerTwo);
        return handlers;
    }

    @Bean(name = "requestHandlerFactory")
    public AbstractFactory<RequestHandler> getRequestHandlerFactory(){
        return new AbstractFactory<RequestHandler>() {
            @Override
            public String getRouteKey(Request<?> msg) {
                return msg.getHeader().getCommand();
            }
        };
    }
    @Bean(name = "routerHandlerFactory")
    public AbstractFactory<RouterHandler> getRouterHandlerFactory(){
        return new AbstractFactory<RouterHandler>() {
            @Override
            public String getRouteKey(Request<?> msg) {
                return msg.getHeader().getType();
            }
        };
    }

}
