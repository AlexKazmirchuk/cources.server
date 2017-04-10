package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.services.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.factories.MessageFactory;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetMyProfileRequest;
import com.softgroup.profile.api.message.SetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class SetMyProfileRequestHandler
        extends AbstractRequestHandler<SetMyProfileRequest,SetMyProfileResponse>
        implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Override
    public String getName() {
        return "set_my_profile";
    }

    @Override
    public Response<SetMyProfileResponse> doHandle(Request<SetMyProfileRequest> msg) {

        ProfileEntity myProfile = profileService.getById(msg.getProfileID());
        myProfile.setUpdateDateTime(System.currentTimeMillis());
        myProfile.setStatus(msg.getData().getProfile().getStatus());
        myProfile.setName(msg.getData().getProfile().getName());
        myProfile.setAvatarUri(msg.getData().getProfile().getAvatarUri());
        profileService.edit(myProfile);

        return MessageFactory.createResponse(msg, new SetMyProfileResponse());
    }
}
