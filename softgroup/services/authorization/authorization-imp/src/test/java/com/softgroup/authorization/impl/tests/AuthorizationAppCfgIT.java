package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.AuthorizationCacheServiceImpl;
import com.softgroup.authorization.impl.handler.LoginRequestHandler;
import com.softgroup.authorization.impl.handler.RegisterRequestHandler;
import com.softgroup.authorization.impl.handler.SmsConfirmRequestHandler;
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

import static org.mockito.Mockito.mock;
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

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName("josh");
        when(profileRepository.findByPhoneNumber("123")).thenReturn(profileEntity);

        //
        return profileRepository;
    }

    @Bean
    public DeviceRepository getDeviceRepository(){
        DeviceRepository deviceRepository = mock(DeviceRepository.class);
        // todo add behavior
        return deviceRepository;
    }

    @Bean
    public ProfileService getProfileService(){
        return new ProfileService();
    }

    @Bean
    public DeviceService getDeviceService(){
        return new DeviceService();
    }

}
