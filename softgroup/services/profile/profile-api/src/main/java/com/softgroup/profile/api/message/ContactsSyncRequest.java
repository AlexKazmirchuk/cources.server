package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.profile.api.dto.ContactDTO;

import java.util.List;

/**
 * Created by sasha on 24.02.17.
 */
public class ContactsSyncRequest implements RequestData {

    private static final long serialVersionUID = 563692140750183986L;

    private List<ContactDTO> addedContacts;
    private List<ContactDTO> removedContacts;

    public List<ContactDTO> getAddedContacts() {
        return addedContacts;
    }

    public void setAddedContacts(List<ContactDTO> addedContacts) {
        this.addedContacts = addedContacts;
    }

    public List<ContactDTO> getRemovedContacts() {
        return removedContacts;
    }

    public void setRemovedContacts(List<ContactDTO> removedContacts) {
        this.removedContacts = removedContacts;
    }
}
