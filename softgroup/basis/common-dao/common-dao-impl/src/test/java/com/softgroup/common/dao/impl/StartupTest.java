package com.softgroup.common.dao.impl;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import com.softgroup.common.dao.impl.repositories.ProfileSettingsRepository;
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

    @Test
    public void test(){
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId("id");
        profileEntity.setName("test_name");

        profileEntity = profileRepository.save(profileEntity);

        ProfileSettingsEntity settingsEntity = new ProfileSettingsEntity();
        settingsEntity.setId("1");
        settingsEntity.setSettingsData("data_1");
        settingsEntity.setProfile(profileEntity);

        ProfileSettingsEntity settingsEntity1 = new ProfileSettingsEntity();
        settingsEntity1.setId("2");
        settingsEntity1.setSettingsData("data_2");
        settingsEntity1.setProfile(profileEntity);



        settingsEntity = profileSettingsRepository.save(settingsEntity);
        settingsEntity1 = profileSettingsRepository.save(settingsEntity1);

        profileEntity.setSettingsEntities(Arrays.asList(settingsEntity, settingsEntity1));

        profileEntity = profileRepository.save(profileEntity);

        ProfileEntity profile = profileRepository.findOne("id");

        List<ProfileSettingsEntity> settings = profile.getSettingsEntities();

        List<ProfileEntity> profileEntities = profileRepository.findByName("name_2");

        List<ProfileEntity> profileEntitiesByQuery = profileRepository.findByNameQuery("name_2");

    }
}
