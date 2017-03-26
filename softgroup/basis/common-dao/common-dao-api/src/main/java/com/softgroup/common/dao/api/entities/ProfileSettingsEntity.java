package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Odin on 29.02.2016.
 */
@Entity
@Table(name = "profile_settings")
public class ProfileSettingsEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2645460488213358603L;

    @Column(name = "settings_data")
    private String settingsData;

    public ProfileSettingsEntity() {
    }

    public String getSettingsData() {
        return settingsData;
    }

    public void setSettingsData(String settingsData) {
        this.settingsData = settingsData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileSettingsEntity)) return false;

        ProfileSettingsEntity that = (ProfileSettingsEntity) o;

        return settingsData != null ? settingsData.equals(that.settingsData) : that.settingsData == null;
    }

    @Override
    public int hashCode() {
        return settingsData != null ? settingsData.hashCode() : 0;
    }
}