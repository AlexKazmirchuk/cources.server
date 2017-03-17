package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

@Entity
@Table(name = "profile_statuses")
public class ProfileStatusEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5692872742644522060L;

    @Column(name = "is_online")
    private Boolean isOnline;

    @Column(name = "last_time_online")
    private Long lastTimeOnline;

    public ProfileStatusEntity() {
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Long getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(Long lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileStatusEntity)) return false;

        ProfileStatusEntity that = (ProfileStatusEntity) o;

        if (isOnline != null ? !isOnline.equals(that.isOnline) : that.isOnline != null) return false;
        return lastTimeOnline != null ? lastTimeOnline.equals(that.lastTimeOnline) : that.lastTimeOnline == null;
    }

    @Override
    public int hashCode() {
        int result = isOnline != null ? isOnline.hashCode() : 0;
        result = 31 * result + (lastTimeOnline != null ? lastTimeOnline.hashCode() : 0);
        return result;
    }
}
