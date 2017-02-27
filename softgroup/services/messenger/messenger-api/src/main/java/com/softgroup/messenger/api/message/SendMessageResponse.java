package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.model.Message;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class SendMessageResponse implements ResponseData {

    private static final long serialVersionUID = 2712924686124537985L;

    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
