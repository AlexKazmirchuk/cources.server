package com.softgroup.messenger.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.api.router.MessengerRouterHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

@Component
public class MessengerRouterHandlerImpl
        extends AbstractRouterHandler<MessengerRequestHandler>
        implements MessengerRouterHandler {

    @Override
    public String getName() {
        return "messenger";
    }
}
