package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.RegistrationCacheData;
import com.softgroup.common.model.mapper.api.ModelMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.protocol.factories.MessageFactory;
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

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public Response<RegisterResponse> doHandle(Request<RegisterRequest> msg) {

        RegistrationCacheData cacheData = modelMapper.map(msg.getData(),RegistrationCacheData.class);

        if (checkIfExist(cacheData.getPhoneNumber())){
            return MessageFactory.createResponse(msg, null, new ResponseStatus(406,"Not acceptable"));
        }

        String authCode = createAuthCode();
        cacheData.setAuthCode(authCode);
        String registrationRequestUuid = putToCache(cacheData);

        RegisterResponse responseData = new RegisterResponse(registrationRequestUuid,REGISTER_TIMEOUT,authCode);

        return MessageFactory.createResponseWithOk(msg, responseData);
    }

    private String putToCache(RegistrationCacheData cacheData){
        String key = UUID.randomUUID().toString();
        cacheService.save(key,cacheData);
        return key;
    }

    private boolean checkIfExist(String phoneNumber){
        // todo implement later
        // this method must be check if data base contains profile with such phone number
        // if exist then return true;
        return false;
    }

    private String createAuthCode(){
        return  String.valueOf(new Random().nextInt(999999));
    }

}
