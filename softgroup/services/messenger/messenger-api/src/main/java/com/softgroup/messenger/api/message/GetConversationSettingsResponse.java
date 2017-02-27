package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationSettingsResponse implements ResponseData{

    private static final long serialVersionUID = 5841296409708314807L;

    private ConversationSettingsDTO conversationSettings;

    public ConversationSettingsDTO getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(ConversationSettingsDTO conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
