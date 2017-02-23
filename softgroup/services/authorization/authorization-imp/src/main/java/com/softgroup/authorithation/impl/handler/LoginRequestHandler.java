package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by sasha on 23.02.17.
 */

@Component
public class LoginRequestHandler extends AbstractRequestHandler implements AuthorizationRequestHandler {

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public Response<LoginResponse> handle(Request msg) {
        // implement later


        //
        return null;
    }
}
