package com.softgroup.common.jwt.impl;

import com.softgroup.common.jwt.api.TokenService;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author AlexKazmirchuk
 * @since 16.03.17.
 */

@Service
public class TokenServiceImpl implements TokenService {

    private static final String SIGN_KEY = "iOiJKV1QiLCJhbGc";

    private static final long EXP_15_MINUTES = 900000L;
    private static final long EXP_YEAR = 31536000000L;

    private static final String PROFILE_ID = "profile_id";
    private static final String DEVICE_ID = "device_id";

    private static final String TYPE = "type";
    private static final String TYPE_SESSION = "session_token";
    private static final String TYPE_DEVICE = "device_token";


    @Override
    public void validateSessionToken(String sessionToken) throws
            ExpiredJwtException,
            MalformedJwtException,
            SignatureException
    {
        Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(sessionToken);
    }

    @Override
    public void validateDeviceToken(String deviceToken) throws
            ExpiredJwtException,
            MalformedJwtException,
            SignatureException
    {
        Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(deviceToken);
    }

    @Override
    public String createSessionToken(String profileID, String deviceID) {
        return  Jwts.builder()
                .claim(PROFILE_ID, profileID)
                .claim(DEVICE_ID, deviceID)
                .claim(TYPE, TYPE_SESSION)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXP_15_MINUTES))
                .signWith(SignatureAlgorithm.HS512, SIGN_KEY)
                .compact();
    }

    @Override
    public String createDeviceToken(String profileID, String deviceID) {
        return Jwts.builder()
                .claim(PROFILE_ID, profileID)
                .claim(DEVICE_ID, deviceID)
                .claim(TYPE, TYPE_DEVICE)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXP_YEAR))
                .signWith(SignatureAlgorithm.HS512, SIGN_KEY)
                .compact();
    }

    private Object getClaimValueByName(String token, String claimName){
        return  Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get(claimName);
    }

    @Override
    public String getProfileID(String token) {
        return (String) getClaimValueByName(token, PROFILE_ID);
    }

    @Override
    public String getDeviceID(String token) {
        return (String) getClaimValueByName(token, DEVICE_ID);
    }

    @Override
    public Long getCreationTime(String token) {
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(token)
                .getBody().getIssuedAt().getTime();
    }

    @Override
    public Long getExpirationTime(String token) {
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(token)
                .getBody().getExpiration().getTime();
    }

    @Override
    public String getTokenType(String token) {
        return (String) getClaimValueByName(token, TYPE);
    }
}
