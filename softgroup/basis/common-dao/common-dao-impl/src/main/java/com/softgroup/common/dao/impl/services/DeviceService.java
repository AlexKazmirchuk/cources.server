package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 19.03.17.
 */

@Service
public class DeviceService extends
        CommonService<DeviceEntity,DeviceRepository>  {

    public DeviceEntity findByProfileAndDeviceID(ProfileEntity profile, String deviceID){
        return getRepository().findByProfileAndDeviceID(profile,deviceID);
    }
}
