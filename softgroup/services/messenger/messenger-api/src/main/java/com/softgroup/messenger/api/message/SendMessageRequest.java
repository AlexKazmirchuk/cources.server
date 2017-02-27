package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.messenger.api.dto.MessageRequestDTO;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class SendMessageRequest implements RequestData {

    private static final long serialVersionUID = -8993432364070398813L;

    private MessageRequestDTO message;

    public MessageRequestDTO getMessage() {
        return message;
    }

    public void setMessage(MessageRequestDTO message) {
        this.message = message;
    }
}
