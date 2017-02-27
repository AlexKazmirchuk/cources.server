package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.model.Conversation;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class CreateConversationResponse implements ResponseData {

    private static final long serialVersionUID = -5144491898526253878L;

    private Conversation conversation;

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
