package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 25.02.17.
 */

@Component
public class HandlerAbstractFactory<T extends RequestHandler> extends AbstractFactory<T> {

    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }

}
