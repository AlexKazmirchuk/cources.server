package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.MessageDTO;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class SendMessageResponse implements ResponseData {

    private static final long serialVersionUID = 2712924686124537985L;

    private MessageDTO message;

    public MessageDTO getMessage() {
        return message;
    }

    public void setMessage(MessageDTO message) {
        this.message = message;
    }
}
