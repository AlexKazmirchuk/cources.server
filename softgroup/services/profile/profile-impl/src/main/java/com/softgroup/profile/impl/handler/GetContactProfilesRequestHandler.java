package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.services.ContactService;
import com.softgroup.common.dao.impl.services.ProfileService;
import com.softgroup.common.model.mapper.api.ModelMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.factories.MessageFactory;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.dto.ProfileDTO;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
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
public class GetContactProfilesRequestHandler
        extends AbstractRequestHandler<GetContactProfilesRequest,GetContactProfilesResponse>
        implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String getName() {
        return "get_contact_profiles";
    }

    @Override
    public Response<GetContactProfilesResponse> doHandle(Request<GetContactProfilesRequest> msg) {

        String profileID = msg.getProfileID();

        ProfileEntity profile = profileService.getById(profileID);
        List<ContactEntity> profileContacts = contactService.findByProfile(profile);

        List<ProfileDTO> profileDTOS = new ArrayList<>();
        for (ContactEntity contact : profileContacts){
            ProfileDTO profileDTO = modelMapper.map(profileService.findByPhoneNumber(contact.getPhone()),ProfileDTO.class);
            profileDTOS.add(profileDTO);
        }

        return MessageFactory.createResponse(msg, new GetContactProfilesResponse(profileDTOS));
    }
}
