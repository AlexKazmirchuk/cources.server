package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationDetailsDTO;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsDetailsResponse implements ResponseData{

    private static final long serialVersionUID = -6430192539856852491L;

    private List<ConversationDetailsDTO> conversationsDetails;

    public List<ConversationDetailsDTO> getConversationsDetails() {
        return conversationsDetails;
    }

    public void setConversationsDetails(List<ConversationDetailsDTO> conversationsDetails) {
        this.conversationsDetails = conversationsDetails;
    }
}
