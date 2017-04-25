package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.softgroup.common.router.api.util.TestUtil.*;
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
        when(handlerOne.handle(REQUEST_WITH_TEST_COMMAND_ONE))
        .thenReturn(createResponse("test_command_one",null));
        when(handlerOne.handle(null)).thenThrow(new IllegalArgumentException());

        RequestHandler handlerTwo = mock(RequestHandler.class);
        when(handlerTwo.getName()).thenReturn("test_command_two");
        when(handlerTwo.handle(REQUEST_WITH_TEST_COMMAND_TWO))
                .thenReturn(createResponse("test_command_two",null));
        when(handlerTwo.handle(null)).thenThrow(new IllegalArgumentException());

        List<RequestHandler> handlers = new ArrayList<>();
        handlers.add(handlerOne);
        handlers.add(handlerTwo);
        return handlers;
    }

    @Bean
    public List<RouterHandler> getRouterHandlerList(){
        RouterHandler handlerOne = mock(RouterHandler.class);
        when(handlerOne.getName()).thenReturn("test_type_one");
        when(handlerOne.handle(REQUEST_WITH_TEST_TYPE_ONE))
                .thenReturn(createResponse(null,"test_type_one"));
        when(handlerOne.handle(null)).thenThrow(new IllegalArgumentException());

        RouterHandler handlerTwo = mock(RouterHandler.class);
        when(handlerTwo.getName()).thenReturn("test_type_two");
        when(handlerTwo.handle(REQUEST_WITH_TEST_TYPE_TWO))
                .thenReturn(createResponse(null,"test_type_two"));
        when(handlerTwo.handle(null)).thenThrow(new IllegalArgumentException());

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
                if (msg == null || msg.getHeader() == null) throw new IllegalArgumentException();
                return msg.getHeader().getCommand();
            }
        };
    }
    @Bean(name = "routerHandlerFactory")
    public AbstractFactory<RouterHandler> getRouterHandlerFactory(){
        return new AbstractFactory<RouterHandler>() {
            @Override
            public String getRouteKey(Request<?> msg) {
                if (msg == null || msg.getHeader() == null) throw new IllegalArgumentException();
                return msg.getHeader().getType();
            }
        };
    }

    @Bean
    public AbstractRouterHandler<RequestHandler> getCommandRouterHandler(){
        return new AbstractRouterHandler<RequestHandler>() {
            @Override
            public String getName() {
                return "test_router_handler";
            }
        };
    }

}
