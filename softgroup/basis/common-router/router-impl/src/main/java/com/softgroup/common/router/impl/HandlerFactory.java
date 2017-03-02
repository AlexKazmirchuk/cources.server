package com.softgroup.common.router.impl;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractFactory;
import com.softgroup.common.router.api.RequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 25.02.17.
 */

@Component
public class HandlerFactory<T extends RequestHandler> extends AbstractFactory<T> {

    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }

}
