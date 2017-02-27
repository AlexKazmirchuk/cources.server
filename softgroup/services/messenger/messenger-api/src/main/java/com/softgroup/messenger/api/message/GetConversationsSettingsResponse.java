package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsSettingsResponse implements ResponseData {

    private static final long serialVersionUID = 3868132571019599769L;

    private List<ConversationSettingsDTO> conversationsSettings;

    public List<ConversationSettingsDTO> getConversationsSettings() {
        return conversationsSettings;
    }

    public void setConversationsSettings(List<ConversationSettingsDTO> conversationsSettings) {
        this.conversationsSettings = conversationsSettings;
    }
}
