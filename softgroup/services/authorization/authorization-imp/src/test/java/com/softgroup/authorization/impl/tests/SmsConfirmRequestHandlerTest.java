package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.api.message.SmsConfirmRequest;
import com.softgroup.authorization.api.message.SmsConfirmResponse;
import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.RegistrationCacheData;
import com.softgroup.authorization.impl.handler.SmsConfirmRequestHandler;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.services.DeviceService;
import com.softgroup.common.dao.impl.services.ProfileService;
import com.softgroup.common.exceptions.InvalidTokenException;
import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.api.TokenType;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatusType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * @author AlexKazmirchuk
 * @since 18.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationAppCfgIT.class})
public class SmsConfirmRequestHandlerTest {

    @Autowired
    private SmsConfirmRequestHandler smsConfirmRequestHandler;

    @Autowired
    private AuthorizationCacheService cacheService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private TokenService tokenService;

    @Before
    public void init(){
        RegistrationCacheData cacheData = new RegistrationCacheData();
        cacheData.setPhoneNumber("3784930034"); // no user with this number in DB
        cacheData.setAuthCode("123456");
        cacheData.setDeviceID("234423"); // no device with this id in db
        cacheService.save("fdc3046b-18fd-4ce5-9dbb-cbe415ca292b",cacheData);

        cacheData = new RegistrationCacheData();
        cacheData.setPhoneNumber("123456789"); // user with such phone number is already in DB
        cacheData.setAuthCode("654321");
        cacheData.setDeviceID("467859"); // no device with this id in db
        cacheService.save("9266632d-ff80-4c63-97c3-def27a1f6d4e",cacheData);

        cacheData = new RegistrationCacheData();
        cacheData.setPhoneNumber("123456789"); // user with such phone number is already in DB
        cacheData.setAuthCode("345632");
        cacheData.setDeviceID("323122"); // device with such deviceId is already in DB
        cacheService.save("02751bf7-c0e5-4442-8ca6-ad4680ec29db",cacheData);
    }

    @Test
    public void checkIfNotNull(){
        assertThat(smsConfirmRequestHandler, notNullValue());
    }

    @Test
    public void testDoHandleMethodWithExistProfileAndNoExistDeviceInDB() throws InvalidTokenException {
        SmsConfirmRequest requestData = new SmsConfirmRequest();
        requestData.setAuthCode("654321");
        requestData.setRegistrationRequestUuid("9266632d-ff80-4c63-97c3-def27a1f6d4e");

        Response<SmsConfirmResponse> response = smsConfirmRequestHandler.doHandle(new Request<>(new ActionHeader(),requestData));

        tokenService.validateDeviceToken(response.getData().getDeviceToken());
        String profileID = tokenService.getProfileID(response.getData().getDeviceToken());
        String deviceID = tokenService.getDeviceID(response.getData().getDeviceToken());
        TokenType tokenType = tokenService.getTokenType(response.getData().getDeviceToken());

        assertThat(profileID, is("11223344"));
        assertThat(deviceID, is("323122"));
        assertThat(tokenType,is(TokenType.DEVICE_TOKEN));

        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus().getCode(),is(ResponseStatusType.OK.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.OK.getMessage()));

        verify(profileService,times(2)).findByPhoneNumber("123456789");
        verify(profileService).edit(any(ProfileEntity.class));
        verify(profileService,times(0)).add(any(ProfileEntity.class));

        verify(deviceService).findByProfileAndDeviceID(any(ProfileEntity.class),eq("467859"));
        verify(deviceService).add(any(DeviceEntity.class));
        verify(deviceService,times(0)).edit(any(DeviceEntity.class));

        reset(profileService,deviceService);
     }

    @Test
    public void testDoHandleMethodWithExistProfileAndExistDeviceInDB() throws InvalidTokenException {
        SmsConfirmRequest requestData = new SmsConfirmRequest();
        requestData.setAuthCode("345632");
        requestData.setRegistrationRequestUuid("02751bf7-c0e5-4442-8ca6-ad4680ec29db");

        Response<SmsConfirmResponse> response = smsConfirmRequestHandler.doHandle(new Request<>(new ActionHeader(),requestData));

        tokenService.validateDeviceToken(response.getData().getDeviceToken());
        String profileID = tokenService.getProfileID(response.getData().getDeviceToken());
        String deviceID = tokenService.getDeviceID(response.getData().getDeviceToken());
        TokenType tokenType = tokenService.getTokenType(response.getData().getDeviceToken());

        assertThat(profileID, is("11223344"));
        assertThat(deviceID, is("323122"));
        assertThat(tokenType,is(TokenType.DEVICE_TOKEN));

        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus().getCode(),is(ResponseStatusType.OK.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.OK.getMessage()));

        verify(profileService,times(2)).findByPhoneNumber("123456789");
        verify(profileService).edit(any(ProfileEntity.class));
        verify(profileService,times(0)).add(any(ProfileEntity.class));

        verify(deviceService,times(2)).findByProfileAndDeviceID(any(ProfileEntity.class),eq("323122"));
        verify(deviceService).edit(any(DeviceEntity.class));
        verify(deviceService,times(0)).add(any(DeviceEntity.class));

        reset(profileService,deviceService);
    }

    @Test
    public void testDoHandleMethodWithNoExistProfileInDB() throws InvalidTokenException {
        SmsConfirmRequest requestData = new SmsConfirmRequest();
        requestData.setAuthCode("123456");
        requestData.setRegistrationRequestUuid("fdc3046b-18fd-4ce5-9dbb-cbe415ca292b");

        Response<SmsConfirmResponse> response = smsConfirmRequestHandler.doHandle(new Request<>(new ActionHeader(),requestData));

        tokenService.validateDeviceToken(response.getData().getDeviceToken());
        String profileID = tokenService.getProfileID(response.getData().getDeviceToken());
        String deviceID = tokenService.getDeviceID(response.getData().getDeviceToken());
        TokenType tokenType = tokenService.getTokenType(response.getData().getDeviceToken());

        assertThat(profileID, is("11223344"));
        assertThat(deviceID, is("323122"));
        assertThat(tokenType,is(TokenType.DEVICE_TOKEN));

        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus().getCode(),is(ResponseStatusType.OK.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.OK.getMessage()));

        verify(profileService,times(1)).findByPhoneNumber("3784930034");
        verify(profileService,times(0)).edit(any(ProfileEntity.class));
        verify(profileService).add(any(ProfileEntity.class));

        verify(deviceService,times(1)).findByProfileAndDeviceID(any(ProfileEntity.class),eq("234423"));
        verify(deviceService).add(any(DeviceEntity.class));
        verify(deviceService,times(0)).edit(any(DeviceEntity.class));

        reset(profileService,deviceService);
    }

    @Test
    public void testDoHandleMethodWithNoExistRegCacheDataWithSuchUUID(){
        SmsConfirmRequest requestData = new SmsConfirmRequest();
        requestData.setAuthCode("123456");
        requestData.setRegistrationRequestUuid("36c5744b-13f7-4c05-94bb-c3e445ca292b");

        Response<SmsConfirmResponse> response = smsConfirmRequestHandler.doHandle(new Request<>(new ActionHeader(),requestData));

        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getStatus().getCode(),is(ResponseStatusType.NOT_ACCEPTABLE.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.NOT_ACCEPTABLE.getMessage()));

        verifyZeroInteractions(profileService);
        verifyZeroInteractions(deviceService);

    }

    @Test
    public void testDoHandleMethodWithNotCorrectUUID(){
        SmsConfirmRequest requestData = new SmsConfirmRequest();
        requestData.setAuthCode("123456");
        requestData.setRegistrationRequestUuid("36c5334c05-94bu9ur0345ca292b");

        Response<SmsConfirmResponse> response = smsConfirmRequestHandler.doHandle(new Request<>(new ActionHeader(),requestData));

        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));

        verifyZeroInteractions(profileService);
        verifyZeroInteractions(deviceService);

    }

    @Test
    public void testDoHandleMethodWithNullValuesInRequestData(){
        SmsConfirmRequest requestData = new SmsConfirmRequest();
        requestData.setAuthCode(null);
        requestData.setRegistrationRequestUuid("23c5564b-13f7-4c05-94bb-c3e445ca292b");

        Response<SmsConfirmResponse> response = smsConfirmRequestHandler.doHandle(new Request<>(new ActionHeader(),requestData));

        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));

        requestData = new SmsConfirmRequest();
        requestData.setAuthCode("435467");
        requestData.setRegistrationRequestUuid(null);

        response = smsConfirmRequestHandler.doHandle(new Request<>(new ActionHeader(),requestData));

        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));

        verifyZeroInteractions(profileService);
        verifyZeroInteractions(deviceService);

    }
}
