package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.CursorDTO;
import com.softgroup.messenger.api.dto.MessageDTO;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetMessagesResponse implements ResponseData {

    private static final long serialVersionUID = 5887586929589615635L;

    private List<MessageDTO> messages;

    private String totalUnread;

    private CursorDTO cursor;

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }

    public String getTotalUnread() {
        return totalUnread;
    }

    public void setTotalUnread(String totalUnread) {
        this.totalUnread = totalUnread;
    }

    public CursorDTO getCursor() {
        return cursor;
    }

    public void setCursor(CursorDTO cursor) {
        this.cursor = cursor;
    }
}
