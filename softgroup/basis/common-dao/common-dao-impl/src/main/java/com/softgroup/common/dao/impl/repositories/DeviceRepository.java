package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;

/**
 * @author AlexKazmirchuk
 * @since 19.03.17.
 */

public interface DeviceRepository extends BaseRepository<DeviceEntity> {

    DeviceEntity findByProfileAndDeviceID(ProfileEntity profile, String deviceID);
}
