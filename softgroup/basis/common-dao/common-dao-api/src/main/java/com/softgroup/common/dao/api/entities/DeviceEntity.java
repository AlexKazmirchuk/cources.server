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

    @Column(name = "last_confirmation_data")
    private Long lastConfirmationData;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    public Long getLastConfirmationData() {
        return lastConfirmationData;
    }

    public void setLastConfirmationData(Long lastConfirmationData) {
        this.lastConfirmationData = lastConfirmationData;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceEntity)) return false;

        DeviceEntity that = (DeviceEntity) o;

        if (lastConfirmationData != null ? !lastConfirmationData.equals(that.lastConfirmationData) : that.lastConfirmationData != null)
            return false;
        return profile != null ? profile.equals(that.profile) : that.profile == null;
    }

    @Override
    public int hashCode() {
        int result = lastConfirmationData != null ? lastConfirmationData.hashCode() : 0;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        return result;
    }
}
