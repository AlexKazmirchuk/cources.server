package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class ProfileService extends
        CommonService<ProfileEntity,ProfileRepository> {
}
