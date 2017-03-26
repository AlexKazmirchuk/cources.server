package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Odin on 29.02.2016.
 */
@Entity
@Table(name = "profiles")
public class ProfileEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 2645460488213358603L;

	@Column(name = "phone_number")
    private String phoneNumber;

	@Column(name = "create_date_time")
    private Long createDateTime;

	@Column(name = "update_date_time")
	private Long updateDateTime;

	@Column(name = "name")
    private String name;

	@Column(name = "status")
    private String status;

	@Column(name = "avatar_uri")
    private String avatarUri;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_settings_id")
	private ProfileSettingsEntity settings;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Long createDateTime) {
        this.createDateTime = createDateTime;
    }

	public Long getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Long updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public ProfileSettingsEntity getSettings() {
        return settings;
    }

    public void setSettings(ProfileSettingsEntity settings) {
        this.settings = settings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileEntity)) return false;

        ProfileEntity that = (ProfileEntity) o;

        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (createDateTime != null ? !createDateTime.equals(that.createDateTime) : that.createDateTime != null)
            return false;
        if (updateDateTime != null ? !updateDateTime.equals(that.updateDateTime) : that.updateDateTime != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (avatarUri != null ? !avatarUri.equals(that.avatarUri) : that.avatarUri != null) return false;
        return settings != null ? settings.equals(that.settings) : that.settings == null;
    }

    @Override
    public int hashCode() {
        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (createDateTime != null ? createDateTime.hashCode() : 0);
        result = 31 * result + (updateDateTime != null ? updateDateTime.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (avatarUri != null ? avatarUri.hashCode() : 0);
        result = 31 * result + (settings != null ? settings.hashCode() : 0);
        return result;
    }
}