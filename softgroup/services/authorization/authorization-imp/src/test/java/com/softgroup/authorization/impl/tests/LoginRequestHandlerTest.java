package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.impl.handler.LoginRequestHandler;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.api.TokenType;
import com.softgroup.common.jwt.configuration.TokenServiceAppCfg;
import com.softgroup.common.jwt.exceptions.InvalidTokenException;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatusType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author AlexKazmirchuk
 * @since 12.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationAppCfgIT.class})
public class LoginRequestHandlerTest {

    @Autowired
    private LoginRequestHandler loginRequestHandler;

    @Autowired
    private TokenService tokenService;

    public void checkIfNotNull(){
        assertThat(loginRequestHandler, notNullValue());
    }

    @Test
    public void getNameMethodTest(){
        assertThat(loginRequestHandler.getName(),is("login"));
    }

    @Test
    public void doHandleMethodTestWithCorrectData() throws InvalidTokenException {
        String deviceToken = tokenService.createDeviceToken("some name", "some device id");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setDeviceToken(deviceToken);
        Response<LoginResponse> response = loginRequestHandler.doHandle(new Request<>(new ActionHeader(),loginRequest));

        assertThat(response,notNullValue());
        assertThat(response.getData(),notNullValue());
        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus(),notNullValue());

        tokenService.validateSessionToken(response.getData().getToken());

        assertThat(tokenService.getTokenType(response.getData().getToken()),is(TokenType.SESSION_TOKEN));
        assertThat(tokenService.getProfileID(response.getData().getToken()),is("some name"));
        assertThat(tokenService.getDeviceID(response.getData().getToken()),is("some device id"));

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.OK.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.OK.getMessage()));

    }

    @Test
    public void doHandleMethodTestWithNotCorrectData(){
        String deviceToken = "some incorrect token";

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setDeviceToken(deviceToken);
        Response<LoginResponse> response = loginRequestHandler.doHandle(new Request<>(new ActionHeader(),loginRequest));

        assertThat(response,notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus(),notNullValue());

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.NOT_ACCEPTABLE.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.NOT_ACCEPTABLE.getMessage()));
    }

    @Test
    public void doHandleMethodTestWithNullData(){
        Response<LoginResponse> response = loginRequestHandler.doHandle(new Request<>(new ActionHeader(),null));

        assertThat(response,notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus(),notNullValue());

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));
    }

    @Test
    public void doHandleMethodTestWithNullValuesInData(){
        LoginRequest loginRequest = new LoginRequest();
        Response<LoginResponse> response = loginRequestHandler.doHandle(new Request<>(new ActionHeader(),loginRequest));

        assertThat(response,notNullValue());
        assertThat(response.getData(),nullValue());
        assertThat(response.getHeader(),notNullValue());
        assertThat(response.getStatus(),notNullValue());

        assertThat(response.getStatus().getCode(),is(ResponseStatusType.BAD_REQUEST.getCode()));
        assertThat(response.getStatus().getMessage(),is(ResponseStatusType.BAD_REQUEST.getMessage()));
    }

}
