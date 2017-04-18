package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.impl.handler.RegisterRequestHandler;
import com.softgroup.common.jwt.exceptions.InvalidTokenException;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatusType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author AlexKazmirchuk
 * @since 18.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationAppCfgIT.class})
public class RegisterRequestHandlerTest {

    @Autowired
    private RegisterRequestHandler registerRequestHandler;

    @Test
    public void checkIfNotNull(){
        assertThat(registerRequestHandler, notNullValue());
    }

    @Test
    public void getNameMethodTest(){
        assertThat(registerRequestHandler.getName(),is("register"));
    }

    @Test
    public void doHandleMethodTestWithCorrectData() throws InvalidTokenException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setDeviceID("some deviceID");
        registerRequest.setLocaleCode("UK_uk");
        registerRequest.setPhoneNumber("38940093023");

        Response<RegisterResponse> response = registerRequestHandler.doHandle(new Request<>(new ActionHeader(),registerRequest));

        assertThat(response,notNullValue());
        assertThat(response.getData(),notNullValue());
        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus(),notNullValue());

        UUID uuid = UUID.fromString(response.getData().getRegistrationRequestUuid());
        assertThat(response.getData().getRegistrationTimeoutSec(), is("1800"));

        int authCode = Integer.parseInt(response.getData().getAuthCode());

        assertThat(authCode >= 0, is(true));
        assertThat(authCode <= 999999, is(true));

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.OK.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.OK.getMessage()));

    }

    @Test
    @Ignore // because validation of locale_code and phone_number not implemented in handler now
    public void doHandleMethodTestWithNotCorrectData(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setDeviceID("some deviceID");
        registerRequest.setLocaleCode("jskjdokflsk");
        registerRequest.setPhoneNumber("3894*(Dsd()D0s");

        Response<RegisterResponse> response = registerRequestHandler.doHandle(new Request<>(new ActionHeader(),registerRequest));

        assertThat(response,notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus(),notNullValue());

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));
    }

    @Test
    public void doHandleMethodTestWithNullData(){
        Response<RegisterResponse> response = registerRequestHandler.doHandle(new Request<>(new ActionHeader(),null));

        assertThat(response,notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus(),notNullValue());

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));
    }

    @Test
    public void doHandleMethodTestWithNullValuesInData(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setPhoneNumber("4453423533");
        Response<RegisterResponse> response = registerRequestHandler.doHandle(new Request<>(new ActionHeader(),registerRequest));

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));

        registerRequest.setLocaleCode("UK_uk");
        response = registerRequestHandler.doHandle(new Request<>(new ActionHeader(),registerRequest));

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));

        registerRequest.setDeviceID("24352t43g63535");
        registerRequest.setLocaleCode(null);
        response = registerRequestHandler.doHandle(new Request<>(new ActionHeader(),registerRequest));

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));
    }

}
