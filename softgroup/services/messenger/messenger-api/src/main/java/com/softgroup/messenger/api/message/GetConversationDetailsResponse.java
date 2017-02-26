package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.model.ConversationDetails;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationDetailsResponse implements ResponseData {

    private static final long serialVersionUID = -943820030004114610L;

    private ConversationDetails conversationDetails;

    public ConversationDetails getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(ConversationDetails conversationDetails) {
        this.conversationDetails = conversationDetails;
    }
}
