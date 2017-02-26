package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class MessagesReadConfirmationRequest implements RequestData {

    private static final long serialVersionUID = -646632386542250256L;

    private String conversationID;
    private List<String> messagesIds;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public List<String> getMessagesIds() {
        return messagesIds;
    }

    public void setMessagesIds(List<String> messagesIds) {
        this.messagesIds = messagesIds;
    }
}
