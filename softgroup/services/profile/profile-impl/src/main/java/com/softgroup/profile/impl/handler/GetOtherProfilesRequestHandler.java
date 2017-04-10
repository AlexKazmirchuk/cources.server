package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.services.ProfileService;
import com.softgroup.common.model.mapper.api.ModelMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.factories.MessageFactory;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.dto.ProfileDTO;
import com.softgroup.profile.api.message.GetOtherProfilesRequest;
import com.softgroup.profile.api.message.GetOtherProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class GetOtherProfilesRequestHandler
        extends AbstractRequestHandler<GetOtherProfilesRequest,GetOtherProfilesResponse>
        implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String getName() {
        return "get_other_profiles";
    }

    @Override
    public Response<GetOtherProfilesResponse> doHandle(Request<GetOtherProfilesRequest> msg) {
        List<ProfileDTO> profileDTOS = new ArrayList<>();

        List<ProfileEntity> profileEntities = profileService.getAllByIds(msg.getData().getUserIDs());

        for(ProfileEntity profileEntity : profileEntities){
            ProfileDTO profileDTO = modelMapper.map(profileEntity,ProfileDTO.class);
            profileDTOS.add(profileDTO);
        }

        return MessageFactory.createResponse(msg, new GetOtherProfilesResponse(profileDTOS));
    }
}
