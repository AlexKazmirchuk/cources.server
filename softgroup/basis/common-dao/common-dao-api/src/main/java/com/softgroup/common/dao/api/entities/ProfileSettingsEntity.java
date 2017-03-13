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

    public String getSettingsData() {
        return settingsData;
    }

    public void setSettingsData(String settingsData) {
        this.settingsData = settingsData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileSettingsEntity that = (ProfileSettingsEntity) o;

        if (!this.getId().equals(that.getId())) return false;
        return settingsData.equals(that.settingsData);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + settingsData.hashCode();
        return result;
    }
}