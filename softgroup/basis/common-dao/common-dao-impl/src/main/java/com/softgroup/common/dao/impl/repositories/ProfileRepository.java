package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ProfileEntity;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

public interface ProfileRepository extends BaseRepository<ProfileEntity> {

    List<ProfileEntity> findByName(String s);

    List<ProfileEntity> findByNameAndPhoneNumber(String s, String number);
}
