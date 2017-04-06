package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.exceptions.InvalidTokenException;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatusType;
import com.softgroup.common.protocol.factories.MessageFactory;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 23.02.17.
 */

@Component
public class LoginRequestHandler
        extends AbstractRequestHandler<LoginRequest,LoginResponse>
        implements AuthorizationRequestHandler {

    @Autowired
    private TokenService tokenService;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public Response<LoginResponse> doHandle(Request<LoginRequest> msg) {
        try {
            String deviceToken = msg.getData().getDeviceToken();
            tokenService.validateDeviceToken(deviceToken);
            String sessionToken = tokenService.createSessionToken(
                    tokenService.getProfileID(deviceToken)
                   ,tokenService.getDeviceID(deviceToken));
            return MessageFactory.createResponse(msg, new LoginResponse(sessionToken));
        } catch (InvalidTokenException e) {
            return MessageFactory.createResponse(msg, ResponseStatusType.NOT_ACCEPTABLE);
        }
    }
}
