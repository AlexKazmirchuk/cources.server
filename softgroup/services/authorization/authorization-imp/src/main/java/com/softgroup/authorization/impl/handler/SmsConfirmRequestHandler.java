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
import com.softgroup.common.protocol.ResponseStatusType;
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

            ProfileEntity profile = processProfile(regData);
            DeviceEntity device = processDevice(profile,regData);

            String deviceToken = tokenService.createDeviceToken(profile.getId(),device.getId());

            return MessageFactory.createResponse(msg,new SmsConfirmResponse(deviceToken));
        } else {
            return MessageFactory.createResponse(msg, ResponseStatusType.NOT_ACCEPTABLE );
        }
    }

    private ProfileEntity processProfile(RegistrationCacheData regData){
        if(checkIfProfileExist(regData.getPhoneNumber())){
            return updateProfile(regData.getPhoneNumber());
        } else {
            return  createAndSaveProfile(regData);
        }
    }

    private DeviceEntity processDevice(ProfileEntity profile, RegistrationCacheData regData){
        if (checkIfDeviceExist(profile,regData.getDeviceID())){
            return updateDevice(profile,regData.getDeviceID());
        } else {
            return createAndSaveDevice(regData,profile);
        }
    }

    private boolean checkIfProfileExist(String phoneNumber){
        if (profileService.findByPhoneNumber(phoneNumber) == null){
            return false;
        }
        return true;
    }

    private boolean checkIfDeviceExist(ProfileEntity profile, String deviceID){
        if (deviceService.findByProfileAndDeviceID(profile,deviceID) == null){
            return false;
        }
        return true;
    }

    private ProfileEntity createAndSaveProfile(RegistrationCacheData regData){
        ProfileEntity profile = new ProfileEntity();
        profile.setCreateDateTime(System.currentTimeMillis());
        profile.setPhoneNumber(regData.getPhoneNumber());
        profile.setUpdateDateTime(System.currentTimeMillis());
        return profileService.add(profile);
    }

    private ProfileEntity updateProfile(String phoneNumber){
        ProfileEntity profile = profileService.findByPhoneNumber(phoneNumber);
        profile.setUpdateDateTime(System.currentTimeMillis());
        return profile;
    }

    private DeviceEntity createAndSaveDevice(RegistrationCacheData regData, ProfileEntity profile){
        DeviceEntity device = new DeviceEntity();
        device.setLocale(regData.getLocaleCode());
        device.setDeviceID(regData.getDeviceID());
        device.setLastConfirmationDate(System.currentTimeMillis());
        device.setProfile(profile);
        return deviceService.add(device);
    }

    private DeviceEntity updateDevice(ProfileEntity profile, String deviceID){
        DeviceEntity device = deviceService.findByProfileAndDeviceID(profile,deviceID);
        device.setLastConfirmationDate(System.currentTimeMillis());
        return deviceService.edit(device);
    }

}
