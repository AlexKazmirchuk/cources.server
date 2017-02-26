package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.model.ConversationSettings;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsSettingsResponse implements ResponseData {

    private static final long serialVersionUID = 3868132571019599769L;

    private List<ConversationSettings> conversationsSettings;

    public List<ConversationSettings> getConversationsSettings() {
        return conversationsSettings;
    }

    public void setConversationsSettings(List<ConversationSettings> conversationsSettings) {
        this.conversationsSettings = conversationsSettings;
    }
}
