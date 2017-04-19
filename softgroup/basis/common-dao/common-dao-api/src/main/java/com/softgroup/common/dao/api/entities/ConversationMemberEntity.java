package com.softgroup.common.dao.api.entities;

import com.softgroup.common.dao.api.enums.ConversationMemberType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author AlexKazmirchuk
 * @since 15.04.17.
 */

@Entity
@Table(name = "conversation_members")
public class ConversationMemberEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1904453545312427708L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private ConversationMemberType status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private ConversationEntity conversation;

    @Column(name = "join_date")
    private Date joinDate;

    public ConversationMemberEntity(ProfileEntity profile, ConversationMemberType status, ConversationEntity conversation, Date joinDate) {
        this.profile = profile;
        this.status = status;
        this.conversation = conversation;
        this.joinDate = joinDate;
    }

    public ConversationMemberEntity() {
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public ConversationMemberType getStatus() {
        return status;
    }

    public void setStatus(ConversationMemberType status) {
        this.status = status;
    }

    public ConversationEntity getConversation() {
        return conversation;
    }

    public void setConversation(ConversationEntity conversation) {
        this.conversation = conversation;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversationMemberEntity)) return false;

        ConversationMemberEntity that = (ConversationMemberEntity) o;

        if (profile != null ? !profile.equals(that.profile) : that.profile != null) return false;
        if (status != that.status) return false;
        if (conversation != null ? !conversation.equals(that.conversation) : that.conversation != null) return false;
        return joinDate != null ? joinDate.equals(that.joinDate) : that.joinDate == null;
    }

    @Override
    public int hashCode() {
        int result = profile != null ? profile.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (conversation != null ? conversation.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        return result;
    }
}
