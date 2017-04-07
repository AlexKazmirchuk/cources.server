package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ContactEntity;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

public interface ContactRepository extends BaseRepository<ContactEntity> {

    ContactEntity findByPhone(String phone);

}
