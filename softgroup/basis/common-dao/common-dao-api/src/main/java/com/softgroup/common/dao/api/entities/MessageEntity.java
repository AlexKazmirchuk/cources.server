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
@Table(name = "messages")
public class MessageEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6779438608811972046L;

    @Column(name = "sender_id")
    private String senderID; // or ProfileEntity sender?

    @Column(name = "conversation_id")
    private String conversationID; // or Conversation conversation?

    @Column(name = "message_type")
    private Integer messageType;

    @Column(name = "payload")
    private String payload;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "server_receive_time")
    private Long serverReceiveTime;

    @Column(name = "message_index")
    private Long messageIndex;

    public MessageEntity() {
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getServerReceiveTime() {
        return serverReceiveTime;
    }

    public void setServerReceiveTime(Long serverReceiveTime) {
        this.serverReceiveTime = serverReceiveTime;
    }

    public Long getMessageIndex() {
        return messageIndex;
    }

    public void setMessageIndex(Long messageIndex) {
        this.messageIndex = messageIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageEntity)) return false;

        MessageEntity that = (MessageEntity) o;

        if (senderID != null ? !senderID.equals(that.senderID) : that.senderID != null) return false;
        if (conversationID != null ? !conversationID.equals(that.conversationID) : that.conversationID != null)
            return false;
        if (messageType != null ? !messageType.equals(that.messageType) : that.messageType != null) return false;
        if (payload != null ? !payload.equals(that.payload) : that.payload != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (serverReceiveTime != null ? !serverReceiveTime.equals(that.serverReceiveTime) : that.serverReceiveTime != null)
            return false;
        return messageIndex != null ? messageIndex.equals(that.messageIndex) : that.messageIndex == null;
    }

    @Override
    public int hashCode() {
        int result = senderID != null ? senderID.hashCode() : 0;
        result = 31 * result + (conversationID != null ? conversationID.hashCode() : 0);
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (serverReceiveTime != null ? serverReceiveTime.hashCode() : 0);
        result = 31 * result + (messageIndex != null ? messageIndex.hashCode() : 0);
        return result;
    }
}
