package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class UpdateConversationSettingsRequest implements RequestData {

    private static final long serialVersionUID = 9192314828053352547L;

    private ConversationSettingsDTO conversationSettings;

    public ConversationSettingsDTO getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(ConversationSettingsDTO conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
