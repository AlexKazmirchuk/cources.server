package com.softgroup.common.jwt;

import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.api.TokenType;
import com.softgroup.common.jwt.impl.TokenServiceImpl;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

/**
 * @author AlexKazmirchuk
 * @since 16.03.17.
 */

public class TokenServiceTest {

    private TokenService tokenService = new TokenServiceImpl();
    private String deviceToken;
    private String sessionToken;

    @Before
    public void init(){
        tokenService = new TokenServiceImpl();
        deviceToken = tokenService.createDeviceToken("test_user_id1","test_user_device_id1");
        sessionToken = tokenService.createSessionToken("test_user_id2","test_user_device_id2");
    }

    @Test
    public void createDeviceTokenMethodTest(){
        assertThat(deviceToken, notNullValue());
        assertThat(deviceToken.length(), greaterThan(3));
        String[] tokenParts = deviceToken.split("\\.");
        assertThat(tokenParts.length, is(3));
    }

    @Test
    public void createSessionTokenMethodTest(){
        assertThat(sessionToken, notNullValue());
        assertThat(sessionToken.length(), greaterThan(3));
        String[] tokenParts = sessionToken.split("\\.");
        assertThat(tokenParts.length, is(3));
    }

    @Test
    public void validateDeviceTokenMethodTest(){
        tokenService.validateDeviceToken(deviceToken);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateDeviceTokenMethodWithNullParameterTest(){
        tokenService.validateDeviceToken(null);
    }

    @Test(expected = MalformedJwtException.class)
    public void validateDeviceTokenMethodWithIncorrectParameterTest(){
        tokenService.validateDeviceToken("ssssswwwwwww.dsd.sdsd");
    }

    @Test(expected = SignatureException.class)
    public void validateDeviceTokenMethodWithIncorrectTokenTest(){
        tokenService.validateDeviceToken(deviceToken + "R");
    }

    @Test
    public void validateSessionTokenMethodTest(){
        tokenService.validateSessionToken(sessionToken);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateSessionTokenMethodWithNullParameterTest(){
        tokenService.validateSessionToken(null);
    }

    @Test(expected = MalformedJwtException.class)
    public void validateSessionTokenMethodWithIncorrectParameterTest(){
        tokenService.validateSessionToken("fdf.dsd.sdsd");
    }

    @Test(expected = SignatureException.class)
    public void validateSessionTokenMethodWithIncorrectTokenTest(){
        tokenService.validateSessionToken(sessionToken + "KjOp");
    }

    @Test
    public void getProfileIDMethodTest(){
        assertThat(tokenService.getProfileID(deviceToken), notNullValue());
        assertThat(tokenService.getProfileID(sessionToken), notNullValue());
        assertThat(tokenService.getProfileID(deviceToken), is("test_user_id1"));
        assertThat(tokenService.getProfileID(sessionToken), is("test_user_id2"));
    }

    @Test
    public void getDeviceIDMethodTest(){
        assertThat(tokenService.getDeviceID(deviceToken), notNullValue());
        assertThat(tokenService.getDeviceID(sessionToken), notNullValue());
        assertThat(tokenService.getDeviceID(deviceToken), is("test_user_device_id1"));
        assertThat(tokenService.getDeviceID(sessionToken), is("test_user_device_id2"));
    }

    @Test
    public void getCreationTimeMethodTest(){
        assertThat(tokenService.getCreationTime(deviceToken), notNullValue());
        assertThat(tokenService.getCreationTime(sessionToken), notNullValue());
        assertThat(tokenService.getCreationTime(deviceToken), greaterThan(System.currentTimeMillis()-1000));
        assertThat(tokenService.getCreationTime(sessionToken), greaterThan(System.currentTimeMillis()-1000));
        assertThat(tokenService.getCreationTime(deviceToken), lessThan(System.currentTimeMillis()+1000));
        assertThat(tokenService.getCreationTime(sessionToken), lessThan(System.currentTimeMillis()+1000));
    }

    @Test
    public void getExpirationTimeMethodTest(){
        assertThat(tokenService.getExpirationTime(deviceToken), notNullValue());
        assertThat(tokenService.getExpirationTime(sessionToken), notNullValue());
        assertThat(tokenService.getExpirationTime(deviceToken), greaterThan(System.currentTimeMillis()-1000 + 31536000000L)); //year
        assertThat(tokenService.getExpirationTime(sessionToken), greaterThan(System.currentTimeMillis()-1000 + 900000L)); // 15 minutes
        assertThat(tokenService.getExpirationTime(deviceToken), lessThan(System.currentTimeMillis()+1000 + 31536000000L)); //year
        assertThat(tokenService.getExpirationTime(sessionToken), lessThan(System.currentTimeMillis()+1000 + 900000L)); // 15 minutes
    }

    @Test
    public void getTokenTypeMethodTest(){
        assertThat(tokenService.getTokenType(deviceToken), notNullValue());
        assertThat(tokenService.getTokenType(sessionToken), notNullValue());
        assertThat(tokenService.getTokenType(deviceToken), is(TokenType.DEVICE_TOKEN));
        assertThat(tokenService.getTokenType(sessionToken), is(TokenType.SESSION_TOKEN));
    }
}
