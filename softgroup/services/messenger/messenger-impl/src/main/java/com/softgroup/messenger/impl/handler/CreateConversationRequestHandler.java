package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.CreateConversationRequest;
import com.softgroup.messenger.api.message.CreateConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

@Component
public class CreateConversationRequestHandler
        extends AbstractRequestHandler<CreateConversationRequest,CreateConversationResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "create_conversation";
    }

    @Override
    public Response<CreateConversationResponse> doHandle(Request<CreateConversationRequest> msg) {
        // todo implement later


        //
        return null;
    }
}
