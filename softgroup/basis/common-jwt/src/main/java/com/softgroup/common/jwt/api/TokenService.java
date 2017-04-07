package com.softgroup.common.jwt.api;

import com.softgroup.common.exceptions.InvalidTokenException;

/**
 * @author AlexKazmirchuk
 * @since 16.03.17.
 */

public interface TokenService {

    void validateSessionToken(String sessionToken) throws InvalidTokenException;

    void validateDeviceToken(String deviceToken) throws InvalidTokenException;

    String createSessionToken(String profileID, String deviceID);

    String createDeviceToken(String profileID, String deviceID);

    String getProfileID(String token) throws InvalidTokenException;

    String getDeviceID(String token) throws InvalidTokenException;

    Long getCreationTime(String token) throws InvalidTokenException;

    Long getExpirationTime(String token) throws InvalidTokenException;

    TokenType getTokenType(String token) throws InvalidTokenException;
}
