package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by sasha on 23.02.17.
 */

@Component
public class RegisterRequestHandler extends AbstractRequestHandler implements AuthorizationRequestHandler {

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public Response<RegisterResponse> handle(Request msg) {
        // implement later


        //
        return null;
    }
}
