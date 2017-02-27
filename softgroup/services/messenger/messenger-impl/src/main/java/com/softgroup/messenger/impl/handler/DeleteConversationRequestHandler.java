package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class DeleteConversationRequestHandler
        extends AbstractRequestHandler<DeleteConversationRequest,DeleteConversationResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "delete_conversation";
    }

    @Override
    public Response<DeleteConversationResponse> doHandle(Request<DeleteConversationRequest> msg) {
        // todo implement later


        //
        return null;
    }
}
