package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationDetailsDTO;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationDetailsResponse implements ResponseData {

    private static final long serialVersionUID = -943820030004114610L;

    private ConversationDetailsDTO conversationDetails;

    public ConversationDetailsDTO getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(ConversationDetailsDTO conversationDetails) {
        this.conversationDetails = conversationDetails;
    }
}
