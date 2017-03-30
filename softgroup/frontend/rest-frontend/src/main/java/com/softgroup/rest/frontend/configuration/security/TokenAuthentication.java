package com.softgroup.rest.frontend.configuration.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author AlexKazmirchuk
 * @since 29.03.17.
 */
public class TokenAuthentication implements Authentication {

    private static final long serialVersionUID = -3421986039337831938L;

    private boolean authenticated  = true;
    private String profileID;
    private String deviceID;

    public TokenAuthentication(String profileID, String deviceID) {
        this.profileID = profileID;
        this.deviceID = deviceID;
    }

    public String getProfileID() {
        return profileID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return profileID;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        authenticated = b;
    }

    @Override
    public String getName() {
        return "tokenAuthentication";
    }
}
