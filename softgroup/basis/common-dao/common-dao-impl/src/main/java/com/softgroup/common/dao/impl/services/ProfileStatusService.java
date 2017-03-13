package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.ProfileStatusEntity;
import com.softgroup.common.dao.impl.repositories.ProfileStatusRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class ProfileStatusService extends
        CommonService<ProfileStatusEntity,ProfileStatusRepository> {
}
