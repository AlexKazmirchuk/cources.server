package com.softgroup.authorization.impl.cache;

import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */

public class RegistrationCacheData implements Serializable {

    private static final long serialVersionUID = -7589939630840486542L;

    private Integer registrationTimeoutSec;
    private String authCode;
    private String deviceID;
    private String phoneNumber;
    private String locale;

    public RegistrationCacheData() {
    }

    public RegistrationCacheData(Integer registrationTimeoutSec,
                                 String authCode,
                                 String deviceID,
                                 String phoneNumber,
                                 String locale) {
        this.registrationTimeoutSec = registrationTimeoutSec;
        this.authCode = authCode;
        this.deviceID = deviceID;
        this.phoneNumber = phoneNumber;
        this.locale = locale;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public Integer getRegistrationTimeoutSec() {
        return registrationTimeoutSec;
    }

    public void setRegistrationTimeoutSec(Integer registrationTimeoutSec) {
        this.registrationTimeoutSec = registrationTimeoutSec;
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

        RegistrationCacheData that = (RegistrationCacheData) o;

        if (registrationTimeoutSec != null ? !registrationTimeoutSec.equals(that.registrationTimeoutSec) : that.registrationTimeoutSec != null)
            return false;
        if (authCode != null ? !authCode.equals(that.authCode) : that.authCode != null) return false;
        if (deviceID != null ? !deviceID.equals(that.deviceID) : that.deviceID != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        return locale != null ? locale.equals(that.locale) : that.locale == null;
    }

    @Override
    public int hashCode() {
        int result = registrationTimeoutSec != null ? registrationTimeoutSec.hashCode() : 0;
        result = 31 * result + (authCode != null ? authCode.hashCode() : 0);
        result = 31 * result + (deviceID != null ? deviceID.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationCacheData{" +
                "registrationTimeoutSec=" + registrationTimeoutSec +
                ", authCode=" + authCode +
                ", deviceID='" + deviceID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
