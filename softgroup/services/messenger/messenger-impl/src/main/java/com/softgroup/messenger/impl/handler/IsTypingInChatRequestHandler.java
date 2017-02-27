package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.IsTypingInChatRequest;
import com.softgroup.messenger.api.message.IsTypingInChatResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class IsTypingInChatRequestHandler
        extends AbstractRequestHandler<IsTypingInChatRequest,IsTypingInChatResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "is_typing_in_chat";
    }

    @Override
    public Response<IsTypingInChatResponse> doHandle(Request<IsTypingInChatRequest> msg) {
        // todo implement later


        //
        return null;
    }
}

