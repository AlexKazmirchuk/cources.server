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
import com.softgroup.profile.api.dto.ContactDTO;
import com.softgroup.profile.api.message.ContactsSyncRequest;
import com.softgroup.profile.api.message.ContactsSyncResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class ContactsSyncRequestHandler
        extends AbstractRequestHandler<ContactsSyncRequest,ContactsSyncResponse>
        implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String getName() {
        return "contacts_sync";
    }

    @Override
    public Response<ContactsSyncResponse> doHandle(Request<ContactsSyncRequest> msg) {
        ProfileEntity profile = profileService.getById(msg.getProfileID());

        addContacts(profile, msg.getData().getAddedContacts());
        deleteContacts(profile, msg.getData().getRemovedContacts());

        return MessageFactory.createResponse(msg, new ContactsSyncResponse());
    }

    private void addContacts(ProfileEntity profile, List<ContactDTO> addedContacts){
        for (ContactDTO contactDTO : addedContacts) {
            if(contactService.findByPhone(contactDTO.getPhone()) == null){
                ContactEntity contactEntity = modelMapper.map(contactDTO,ContactEntity.class);
                contactEntity.setProfile(profile);
                contactService.add(contactEntity);
            }
        }
    }

    private void deleteContacts(ProfileEntity profile, List<ContactDTO> removedContacts){
        for (ContactDTO contactDTO : removedContacts) {
            ContactEntity contactEntity = contactService.findByPhone(contactDTO.getPhone());
            if (contactEntity.getProfile().getId().equals(profile.getId())){
                contactService.delete(contactEntity.getId());
            }
        }
    }

}
