package com.softgroup.common.dao.impl;

import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.dao.impl.repositories.DeviceRepository;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import com.softgroup.common.dao.impl.repositories.ProfileSettingsRepository;
import com.softgroup.common.dao.impl.services.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Odin on 04.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class StartupTest {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileSettingsRepository profileSettingsRepository;

    @Autowired
    private DeviceService deviceService;

    @Test
    public void test(){
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId("id");
        profileEntity.setName("test_name");

        ProfileSettingsEntity profileSettingsEntity = new ProfileSettingsEntity();
        profileSettingsEntity.setSettingsData("Some info about profile");

        profileEntity.setSettings(profileSettingsEntity);
        profileEntity = profileRepository.save(profileEntity);

//        ProfileEntity returned = profileRepository.findOne("58464096-7541-40c7-80c8-2ed65a7e52f6");
//        System.out.println(returned.getSettings().getSettingsData());

        ProfileEntity profile1 = new ProfileEntity();
        profile1.setAvatarUri("URI http://...");
        profile1.setName("John");
        profile1.setPhoneNumber("749450405");
        profile1.setCreateDateTime(67899434L);
        profile1.setStatus("Online");


        ProfileSettingsEntity settings1 = new ProfileSettingsEntity();
        settings1.setSettingsData("many some settings");
        profile1.setSettings(settings1);

        ProfileEntity returnedProfile = profileRepository.save(profile1);

        DeviceEntity device = new DeviceEntity();
        device.setDeviceID("hKoiY89303KoPp");
        device.setLastConfirmationDate(7394390930L);
        device.setLocale("uk_UK");
        device.setProfile(returnedProfile);

        DeviceEntity device2 = new DeviceEntity();
        device2.setDeviceID("hKoiY89d;;d303KoPp");
        device2.setLastConfirmationDate(73943907843930L);
        device2.setLocale("ru_RU");
        device2.setProfile(returnedProfile);

        deviceService.add(device);
        deviceService.add(device2);




    }
}
