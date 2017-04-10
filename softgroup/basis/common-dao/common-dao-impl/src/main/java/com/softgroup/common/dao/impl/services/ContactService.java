package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class ContactService extends
        CommonService<ContactEntity,ContactRepository> {

    public ContactEntity findByPhone(String phone){
        return getRepository().findByPhone(phone);
    }

    public List<ContactEntity> findByProfile(ProfileEntity profile){
        return getRepository().findByProfile(profile);
    }
}
