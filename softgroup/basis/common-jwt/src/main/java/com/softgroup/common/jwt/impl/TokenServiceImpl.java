package com.softgroup.common.jwt.impl;

import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.api.TokenType;
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


    @Override
    public void validateSessionToken(String sessionToken) throws
            ExpiredJwtException,
            MalformedJwtException,
            SignatureException
    {
        Jwts.parser()
                .require(TYPE, TokenType.SESSION_TOKEN.toString())
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(sessionToken);
    }

    @Override
    public void validateDeviceToken(String deviceToken) throws
            ExpiredJwtException,
            MalformedJwtException,
            SignatureException
    {
        Jwts.parser()
                .require(TYPE,TokenType.DEVICE_TOKEN.toString())
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(deviceToken);
    }

    @Override
    public String createSessionToken(String profileID, String deviceID) {
        return  Jwts.builder()
                .claim(PROFILE_ID, profileID)
                .claim(DEVICE_ID, deviceID)
                .claim(TYPE, TokenType.SESSION_TOKEN)
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
                .claim(TYPE, TokenType.DEVICE_TOKEN)
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
    public TokenType getTokenType(String token) {
        String result = (String) getClaimValueByName(token, TYPE);

        if (result.equals(TokenType.DEVICE_TOKEN.toString())){
            return TokenType.DEVICE_TOKEN;
        } else {
            return TokenType.SESSION_TOKEN;
        }
    }
}
