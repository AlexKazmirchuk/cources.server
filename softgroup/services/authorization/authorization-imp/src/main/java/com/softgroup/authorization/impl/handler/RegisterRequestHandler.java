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
        int regTimeout = 30*60;

        ActionHeader responseHeader = fillHeader(msg.getHeader());
        RegisterResponse responseData = fillResponseData(authCode,registrationRequestUuid,regTimeout);
        ResponseStatus responseStatus = getOkStatus();

        return ResponseFactory.createResponse(responseHeader,responseData,responseStatus);
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

    private RegisterResponse fillResponseData(String authCode, String regUuid, int regTimeout){
        RegisterResponse responseData = new RegisterResponse();
        responseData.setAuthCode(authCode);
        responseData.setRegistrationRequestUuid(regUuid);
        responseData.setRegistrationTimeoutSec(String.valueOf(regTimeout));
        return responseData;
    }

    private ActionHeader fillHeader(ActionHeader requestHeader){
        ActionHeader responseHeader = new ActionHeader();
        responseHeader.setType(requestHeader.getType());
        responseHeader.setCommand(requestHeader.getCommand());
        responseHeader.setVersion(requestHeader.getVersion());
        responseHeader.setOriginUuid(requestHeader.getUuid());
        responseHeader.setUuid(UUID.randomUUID().toString()); //todo fix later
        return responseHeader;
    }

    private ResponseStatus getOkStatus(){
        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");
        return status;
    }

    private ResponseStatus getBadStatus(){
        ResponseStatus status = new ResponseStatus();
        status.setCode(422);
        status.setMessage("Unprocessable Entity");
        return status;
    }
}
