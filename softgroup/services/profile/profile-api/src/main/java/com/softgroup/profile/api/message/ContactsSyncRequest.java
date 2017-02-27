package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.profile.api.model.Contact;

import java.util.List;

/**
 * Created by sasha on 24.02.17.
 */
public class ContactsSyncRequest implements RequestData {

    private static final long serialVersionUID = 563692140750183986L;

    private List<Contact> addedContacts;
    private List<Contact> removedContacts;

    public List<Contact> getAddedContacts() {
        return addedContacts;
    }

    public void setAddedContacts(List<Contact> addedContacts) {
        this.addedContacts = addedContacts;
    }

    public List<Contact> getRemovedContacts() {
        return removedContacts;
    }

    public void setRemovedContacts(List<Contact> removedContacts) {
        this.removedContacts = removedContacts;
    }
}
