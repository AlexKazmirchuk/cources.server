package com.softgroup.authorithation.impl.router;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.api.router.AuthorizationRouterHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sasha on 23.02.17.
 */

@Component
public class AuthorizationRouterHandlerImpl
        extends AbstractRouterHandler<AuthorizationRequestHandler>
        implements AuthorizationRouterHandler{

    public String getName() {
        return "authorization";
    }

}
