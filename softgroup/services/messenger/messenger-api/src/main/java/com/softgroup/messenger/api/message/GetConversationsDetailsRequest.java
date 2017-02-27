package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsDetailsRequest implements RequestData{

    private static final long serialVersionUID = 7433750940119176650L;

    private List<String> conversationsIds;

    public List<String> getConversationsIds() {
        return conversationsIds;
    }

    public void setConversationsIds(List<String> conversationsIds) {
        this.conversationsIds = conversationsIds;
    }
}
