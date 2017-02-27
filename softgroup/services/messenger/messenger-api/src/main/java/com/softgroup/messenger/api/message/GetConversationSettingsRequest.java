package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationSettingsRequest implements RequestData{

    private static final long serialVersionUID = 9153717599335927133L;

    private String conversationID;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
