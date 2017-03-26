package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 19.03.17.
 */

@Entity
@Table(name = "devices")
public class DeviceEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -506229924089552354L;

    @Column(name = "last_confirmation_date")
    private Long lastConfirmationDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private ProfileEntity profile;

    @Column(name = "device_id")
    private String deviceID;

    @Column(name = "locale")
    private String locale;

    public DeviceEntity() {
    }

    public Long getLastConfirmationDate() {
        return lastConfirmationDate;
    }

    public void setLastConfirmationDate(Long lastConfirmationDate) {
        this.lastConfirmationDate = lastConfirmationDate;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceEntity)) return false;

        DeviceEntity that = (DeviceEntity) o;

        if (lastConfirmationDate != null ? !lastConfirmationDate.equals(that.lastConfirmationDate) : that.lastConfirmationDate != null)
            return false;
        if (profile != null ? !profile.equals(that.profile) : that.profile != null) return false;
        if (deviceID != null ? !deviceID.equals(that.deviceID) : that.deviceID != null) return false;
        return locale != null ? locale.equals(that.locale) : that.locale == null;
    }

    @Override
    public int hashCode() {
        int result = lastConfirmationDate != null ? lastConfirmationDate.hashCode() : 0;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (deviceID != null ? deviceID.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }
}
