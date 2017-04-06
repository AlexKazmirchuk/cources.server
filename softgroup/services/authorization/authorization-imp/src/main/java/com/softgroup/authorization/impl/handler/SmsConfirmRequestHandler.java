package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.SmsConfirmRequest;
import com.softgroup.authorization.api.message.SmsConfirmResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.RegistrationCacheData;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.services.DeviceService;
import com.softgroup.common.dao.impl.services.ProfileService;
import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.protocol.factories.MessageFactory;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sasha on 23.02.17.
 */

@Component
public class SmsConfirmRequestHandler
        extends AbstractRequestHandler<SmsConfirmRequest,SmsConfirmResponse>
        implements AuthorizationRequestHandler {

    @Autowired
    private AuthorizationCacheService cacheService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DeviceService deviceService;

    @Override
    public String getName() {
        return "sms_confirm";
    }

    @Override
    public Response<SmsConfirmResponse> doHandle(Request<SmsConfirmRequest> msg) {

        String authCode = msg.getData().getAuthCode();
        String regRequestUuid = msg.getData().getRegistrationRequestUuid();

        RegistrationCacheData regData = cacheService.get(regRequestUuid);

        if (regData != null && (regData.getAuthCode().equals(authCode))){

            ProfileEntity profile = createProfile(regData);
            profile = profileService.add(profile);
            DeviceEntity device = createDevice(regData);
            device.setProfile(profile);
            deviceService.add(device);

            String deviceToken = tokenService.createDeviceToken(profile.getId(),device.getId());

            SmsConfirmResponse responseData = new SmsConfirmResponse(deviceToken);

            return MessageFactory.createResponse(msg,responseData);
        } else {
            return MessageFactory.createResponse(msg, ResponseStatus.NOT_ACCEPTABLE );
        }
    }

    private ProfileEntity createProfile(RegistrationCacheData regData){
        ProfileEntity profile = new ProfileEntity();
        profile.setCreateDateTime(System.currentTimeMillis());
        profile.setPhoneNumber(regData.getPhoneNumber());
        profile.setUpdateDateTime(System.currentTimeMillis());
        return profile;
    }

    private DeviceEntity createDevice(RegistrationCacheData regData){
        DeviceEntity device = new DeviceEntity();
        device.setLocale(regData.getLocaleCode());
        device.setDeviceID(regData.getDeviceID());
        device.setLastConfirmationDate(System.currentTimeMillis());
        return device;
    }

}
