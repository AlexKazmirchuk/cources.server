package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.RegistrationCacheData;
import com.softgroup.common.protocol.*;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */

@Component
public class RegisterRequestHandler
        extends AbstractRequestHandler<RegisterRequest,RegisterResponse>
        implements AuthorizationRequestHandler {

    private static final String REGISTER_TIMEOUT = "1800";

    @Autowired
    private AuthorizationCacheService cacheService;

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public Response<RegisterResponse> doHandle(Request<RegisterRequest> msg) {

        RegistrationCacheData cacheData = createRegCacheData(msg.getData());
        String authCode = createAuthCode();
        cacheData.setAuthCode(authCode);
        String registrationRequestUuid = putToCache(cacheData);

        ActionHeader responseHeader =  ActionHeaderFactory.createHeader(msg.getHeader());
        RegisterResponse responseData = new RegisterResponse(registrationRequestUuid,REGISTER_TIMEOUT,authCode);

        return ResponseFactory.createResponseWithOk(responseHeader,responseData);
    }

    private RegistrationCacheData createRegCacheData(RegisterRequest data){
        RegistrationCacheData cacheData = new RegistrationCacheData();
        cacheData.setPhoneNumber(data.getPhoneNumber());
        cacheData.setLocale(data.getLocaleCode());
        cacheData.setDeviceID(data.getDeviceID());
        return cacheData;
    }

    private String putToCache(RegistrationCacheData cacheData){
        String key = UUID.randomUUID().toString();
        cacheService.save(key,cacheData);
        return key;
    }

    private String createAuthCode(){
        return  String.valueOf(new Random().nextInt(999999));
    }

}
