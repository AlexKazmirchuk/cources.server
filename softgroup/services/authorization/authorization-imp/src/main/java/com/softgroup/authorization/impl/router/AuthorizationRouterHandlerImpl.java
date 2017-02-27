package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.api.router.AuthorizationRouterHandler;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class AuthorizationRouterHandlerImpl
        extends AbstractRouterHandler<AuthorizationRequestHandler>
        implements AuthorizationRouterHandler{

    public String getName() {
        return "authorization";
    }

}
