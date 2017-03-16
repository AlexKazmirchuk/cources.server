package com.softgroup.common.jwt.api;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

/**
 * @author AlexKazmirchuk
 * @since 16.03.17.
 */

public interface TokenService {

    void validateSessionToken(String sessionToken) throws ExpiredJwtException, MalformedJwtException, SignatureException;

    void validateDeviceToken(String deviceToken) throws ExpiredJwtException, MalformedJwtException, SignatureException;

    String createSessionToken(String profileID, String deviceID);

    String createDeviceToken(String profileID, String deviceID);

    String getProfileID(String token);

    String getDeviceID(String token);

    Long getCreationTime(String token);

    Long getExpirationTime(String token);

    String getTokenType(String token);
}
