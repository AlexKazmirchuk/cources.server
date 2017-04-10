package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.impl.services.ProfileService;
import com.softgroup.common.model.mapper.api.ModelMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.factories.MessageFactory;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.dto.ProfileDTO;
import com.softgroup.profile.api.message.GetMyProfileRequest;
import com.softgroup.profile.api.message.GetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class GetMyProfileRequestHandler
        extends AbstractRequestHandler<GetMyProfileRequest,GetMyProfileResponse>
        implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String getName() {
        return "get_my_profile";
    }

    @Override
    public Response<GetMyProfileResponse> doHandle(Request<GetMyProfileRequest> msg) {
        ProfileDTO myProfile = modelMapper.map(profileService.getById(msg.getProfileID()),ProfileDTO.class);
        return MessageFactory.createResponse(msg, new GetMyProfileResponse(myProfile));
    }
}
