package com.softgroup.authorization.impl.cache;

import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */

public class RegistrationCacheData implements Serializable {

    private static final long serialVersionUID = -7589939630840486542L;

    private String authCode;
    private String deviceID;
    private String phoneNumber;
    private String localeCode;

    public RegistrationCacheData() {
    }

    public RegistrationCacheData(String authCode,
                                 String deviceID,
                                 String phoneNumber,
                                 String localeCode) {
        this.authCode = authCode;
        this.deviceID = deviceID;
        this.phoneNumber = phoneNumber;
        this.localeCode = localeCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationCacheData)) return false;

        RegistrationCacheData cacheData = (RegistrationCacheData) o;

        if (authCode != null ? !authCode.equals(cacheData.authCode) : cacheData.authCode != null) return false;
        if (deviceID != null ? !deviceID.equals(cacheData.deviceID) : cacheData.deviceID != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(cacheData.phoneNumber) : cacheData.phoneNumber != null)
            return false;
        return localeCode != null ? localeCode.equals(cacheData.localeCode) : cacheData.localeCode == null;
    }

    @Override
    public int hashCode() {
        int result = authCode != null ? authCode.hashCode() : 0;
        result = 31 * result + (deviceID != null ? deviceID.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (localeCode != null ? localeCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationCacheData{" +
                "authCode='" + authCode + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", locale='" + localeCode + '\'' +
                '}';
    }
}
