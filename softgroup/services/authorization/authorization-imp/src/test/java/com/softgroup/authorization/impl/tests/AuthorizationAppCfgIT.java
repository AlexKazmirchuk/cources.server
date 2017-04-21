package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.AuthorizationCacheServiceImpl;
import com.softgroup.authorization.impl.handler.LoginRequestHandler;
import com.softgroup.authorization.impl.handler.RegisterRequestHandler;
import com.softgroup.authorization.impl.handler.SmsConfirmRequestHandler;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.DeviceRepository;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import com.softgroup.common.dao.impl.services.DeviceService;
import com.softgroup.common.dao.impl.services.ProfileService;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.impl.TokenServiceImpl;
import com.softgroup.common.model.mapper.api.ModelMapper;
import com.softgroup.common.model.mapper.impl.ModelMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * @author AlexKazmirchuk
 * @since 12.04.17.
 */

@Configuration
public class AuthorizationAppCfgIT {

    @Bean
    public LoginRequestHandler getLoginRequestHandler(){
        return new LoginRequestHandler();
    }

    @Bean
    public RegisterRequestHandler getRegisterRequestHandler(){
        return new RegisterRequestHandler();
    }

    @Bean
    public SmsConfirmRequestHandler getSmsConfirmRequestHandler(){
        return new SmsConfirmRequestHandler();
    }

    @Bean
    public TokenService getTokenService(){
        return new TokenServiceImpl();
    }

    @Bean
    public DataMapper getDataMapper(){
        return new JacksonDataMapper();
    }

    @Bean
    public AuthorizationCacheService cacheService(){
        return new AuthorizationCacheServiceImpl();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapperImpl();
    }

    @Bean
    public ProfileRepository getProfileRepository(){
        ProfileRepository profileRepository = mock(ProfileRepository.class);
        // todo add behavior

        ProfileEntity existingProfile = new ProfileEntity();
        existingProfile.setPhoneNumber("123456789");
        existingProfile.setId("11223344");

        when(profileRepository.findByPhoneNumber("123456789")).thenReturn(existingProfile);
        when(profileRepository.save(any(ProfileEntity.class))).thenReturn(existingProfile);
        //
        return profileRepository;
    }

    @Bean
    public DeviceRepository getDeviceRepository(){
        DeviceRepository deviceRepository = mock(DeviceRepository.class);
        // todo add behavior

        DeviceEntity existingDevice = new DeviceEntity();
        existingDevice.setId("323122");
        existingDevice.setDeviceID("137894");

        when(deviceRepository.findByProfileAndDeviceID(any(ProfileEntity.class),eq("323122"))).thenReturn(existingDevice);
        when(deviceRepository.save(any(DeviceEntity.class))).thenReturn(existingDevice);

        //
        return deviceRepository;
    }

    @Bean
    public ProfileService getProfileService(){
        return spy(new ProfileService());
    }

    @Bean
    public DeviceService getDeviceService(){
        return spy(new DeviceService());
    }

}
