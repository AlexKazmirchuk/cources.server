package com.softgroup.authorization.impl.cache;

import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */

public class RegistrationCacheData implements Serializable {

    private static final long serialVersionUID = -7589939630840486542L;

    private String registrationRequestUuid;
    private Integer registrationTimeoutSec;
    private Integer authCode;
    private String deviceID;
    private String phoneNumber;
    private String locale;

    public RegistrationCacheData() {
    }

    public RegistrationCacheData(String registrationRequestUuid,
                                 Integer registrationTimeoutSec,
                                 Integer authCode,
                                 String deviceID,
                                 String phoneNumber,
                                 String locale) {
        this.registrationRequestUuid = registrationRequestUuid;
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

    public String getRegistrationRequestUuid() {
        return registrationRequestUuid;
    }

    public void setRegistrationRequestUuid(String registrationRequestUuid) {
        this.registrationRequestUuid = registrationRequestUuid;
    }

    public Integer getRegistrationTimeoutSec() {
        return registrationTimeoutSec;
    }

    public void setRegistrationTimeoutSec(Integer registrationTimeoutSec) {
        this.registrationTimeoutSec = registrationTimeoutSec;
    }

    public Integer getAuthCode() {
        return authCode;
    }

    public void setAuthCode(Integer authCode) {
        this.authCode = authCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationCacheData)) return false;

        RegistrationCacheData cacheData = (RegistrationCacheData) o;

        if (registrationRequestUuid != null ? !registrationRequestUuid.equals(cacheData.registrationRequestUuid) : cacheData.registrationRequestUuid != null)
            return false;
        if (registrationTimeoutSec != null ? !registrationTimeoutSec.equals(cacheData.registrationTimeoutSec) : cacheData.registrationTimeoutSec != null)
            return false;
        if (authCode != null ? !authCode.equals(cacheData.authCode) : cacheData.authCode != null) return false;
        if (deviceID != null ? !deviceID.equals(cacheData.deviceID) : cacheData.deviceID != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(cacheData.phoneNumber) : cacheData.phoneNumber != null)
            return false;
        return locale != null ? locale.equals(cacheData.locale) : cacheData.locale == null;
    }

    @Override
    public int hashCode() {
        int result = registrationRequestUuid != null ? registrationRequestUuid.hashCode() : 0;
        result = 31 * result + (registrationTimeoutSec != null ? registrationTimeoutSec.hashCode() : 0);
        result = 31 * result + (authCode != null ? authCode.hashCode() : 0);
        result = 31 * result + (deviceID != null ? deviceID.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationCacheData{" +
                "registrationRequestUuid='" + registrationRequestUuid + '\'' +
                ", registrationTimeoutSec=" + registrationTimeoutSec +
                ", authCode=" + authCode +
                ", deviceID='" + deviceID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
