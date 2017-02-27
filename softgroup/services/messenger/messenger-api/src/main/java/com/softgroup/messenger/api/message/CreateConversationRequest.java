package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class CreateConversationRequest implements RequestData {

    private static final long serialVersionUID = -9179734652273263170L;

    private String type;
    private List<String> membersIds;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getMembersIds() {
        return membersIds;
    }

    public void setMembersIds(List<String> membersIds) {
        this.membersIds = membersIds;
    }
}
