package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.messenger.api.model.Cursor;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetMessagesRequest implements RequestData {

    private static final long serialVersionUID = -7661433562055332788L;

    private String conversationID;

    private Cursor cursor;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
