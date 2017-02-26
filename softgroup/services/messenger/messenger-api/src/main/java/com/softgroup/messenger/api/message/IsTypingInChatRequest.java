package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class IsTypingInChatRequest implements RequestData {

    private static final long serialVersionUID = 3783889734144035822L;

    private String conversationID;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
