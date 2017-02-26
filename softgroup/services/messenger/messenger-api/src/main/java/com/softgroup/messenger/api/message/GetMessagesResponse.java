package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.model.Cursor;
import com.softgroup.messenger.api.model.Message;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetMessagesResponse implements ResponseData {

    private static final long serialVersionUID = 5887586929589615635L;

    private List<Message> messages;

    private String totalUnread;

    private Cursor cursor;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getTotalUnread() {
        return totalUnread;
    }

    public void setTotalUnread(String totalUnread) {
        this.totalUnread = totalUnread;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
