package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

@Entity
@Table(name = "contacts")
public class ContactEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3180111570947462349L;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private ProfileEntity profile;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    public ContactEntity() {
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactEntity)) return false;

        ContactEntity that = (ContactEntity) o;

        if (profile != null ? !profile.equals(that.profile) : that.profile != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;
    }

    @Override
    public int hashCode() {
        int result = profile != null ? profile.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
