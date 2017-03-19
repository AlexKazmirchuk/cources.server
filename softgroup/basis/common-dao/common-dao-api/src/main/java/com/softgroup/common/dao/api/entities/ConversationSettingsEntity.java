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
@Table(name = "conversation_settings")
public class ConversationSettingsEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7214265511617637837L;

    @Column(name = "name")
    private String name;

    @Column(name = "admin_id")
    private ProfileEntity admin;

    @Column(name = "logo_image_uri")
    private String logoImageUri;

    public ConversationSettingsEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileEntity getAdmin() {
        return admin;
    }

    public void setAdmin(ProfileEntity admin) {
        this.admin = admin;
    }

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversationSettingsEntity)) return false;

        ConversationSettingsEntity that = (ConversationSettingsEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (admin != null ? !admin.equals(that.admin) : that.admin != null) return false;
        return logoImageUri != null ? logoImageUri.equals(that.logoImageUri) : that.logoImageUri == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (admin != null ? admin.hashCode() : 0);
        result = 31 * result + (logoImageUri != null ? logoImageUri.hashCode() : 0);
        return result;
    }
}
