package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.impl.repositories.ContactRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class ContactService extends
        CommonService<ContactEntity,ContactRepository> {
}
