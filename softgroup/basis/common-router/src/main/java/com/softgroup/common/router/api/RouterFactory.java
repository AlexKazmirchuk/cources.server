package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AlexKazmirchuk
 * @since 25.02.17.
 */

public class RouterFactory<T extends CommonRouterHandler>  {

    @Autowired
    private List<T> handlers;

    private Map<String, T> handlersMap = new HashMap<>();

    @PostConstruct
    public void init(){
        for (T handler: handlers) {
            handlersMap.put(handler.getName(), handler);
        }
    }

    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getType();
    }

    public T getHandler(Request<?> msg){
        return handlersMap.get(getRouteKey(msg));
    }

}
