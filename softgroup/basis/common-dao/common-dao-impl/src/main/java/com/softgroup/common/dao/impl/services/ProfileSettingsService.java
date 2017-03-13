package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.repositories.ProfileSettingsRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class ProfileSettingsService extends
        CommonService<ProfileSettingsEntity,ProfileSettingsRepository> {
}
