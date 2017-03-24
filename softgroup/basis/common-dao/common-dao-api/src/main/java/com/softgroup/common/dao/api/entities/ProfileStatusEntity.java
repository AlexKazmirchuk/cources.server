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

    @Column(name = "last_time_online")
    private Long lastTimeOnline;

    public ProfileStatusEntity() {
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

        return lastTimeOnline != null ? lastTimeOnline.equals(that.lastTimeOnline) : that.lastTimeOnline == null;
    }

    @Override
    public int hashCode() {
        return lastTimeOnline != null ? lastTimeOnline.hashCode() : 0;
    }
}
