package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AlexKazmirchuk
 * @since 27.02.17.
 */

public abstract class AbstractFactory<T extends Handler> implements Factory<T>{

    @Autowired
    private List<T> handlers;

    private Map<String, T> handlersMap = new HashMap<>();

    @PostConstruct
    public void init(){
        for (T handler: handlers) {
            handlersMap.put(handler.getName(), handler);
        }
    }

    public abstract String getRouteKey(Request<?> msg);

    public T getHandler(Request<?> msg){
        return handlersMap.get(getRouteKey(msg));
    }
}
