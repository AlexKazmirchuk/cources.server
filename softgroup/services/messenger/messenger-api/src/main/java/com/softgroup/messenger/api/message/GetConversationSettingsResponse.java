package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.model.ConversationSettings;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationSettingsResponse implements ResponseData{

    private static final long serialVersionUID = 5841296409708314807L;

    private ConversationSettings conversationSettings;

    public ConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(ConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
