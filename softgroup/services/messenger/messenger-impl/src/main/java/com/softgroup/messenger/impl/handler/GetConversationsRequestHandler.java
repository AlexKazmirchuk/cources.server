package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsRequest;
import com.softgroup.messenger.api.message.GetConversationsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsRequestHandler
        extends AbstractRequestHandler<GetConversationsRequest,GetConversationsResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "get_conversations";
    }

    @Override
    public Response<GetConversationsResponse> doHandle(Request<GetConversationsRequest> msg) {
        // todo implement later


        //
        return null;
    }
}
