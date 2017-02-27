package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.messenger.api.dto.CursorDTO;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetMessagesRequest implements RequestData {

    private static final long serialVersionUID = -7661433562055332788L;

    private String conversationID;

    private CursorDTO cursor;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public CursorDTO getCursor() {
        return cursor;
    }

    public void setCursor(CursorDTO cursor) {
        this.cursor = cursor;
    }
}
