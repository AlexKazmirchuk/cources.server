package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsRequest implements RequestData {

    private static final long serialVersionUID = 6607901114661440938L;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
