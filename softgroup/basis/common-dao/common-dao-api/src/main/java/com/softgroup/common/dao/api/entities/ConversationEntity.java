package com.softgroup.common.dao.api.entities;

import com.softgroup.common.dao.api.enums.ConversationType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */
@Entity
@Table(name = "conversations")
public class ConversationEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -8700529675793334330L;

    @Column(name = "name")
    private String name;

    @Column(name = "logo_image_uri")
    private String logoImageUri;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    private ConversationType type;

    @Column(name = "last_message_index")
    private Long lastMessageIndex;

    public ConversationEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }

    public Long getLastMessageIndex() {
        return lastMessageIndex;
    }

    public void setLastMessageIndex(Long lastMessageIndex) {
        this.lastMessageIndex = lastMessageIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversationEntity)) return false;

        ConversationEntity that = (ConversationEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (logoImageUri != null ? !logoImageUri.equals(that.logoImageUri) : that.logoImageUri != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return lastMessageIndex != null ? lastMessageIndex.equals(that.lastMessageIndex) : that.lastMessageIndex == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (logoImageUri != null ? logoImageUri.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (lastMessageIndex != null ? lastMessageIndex.hashCode() : 0);
        return result;
    }
}
