package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsByIdsRequest;
import com.softgroup.messenger.api.message.GetConversationsByIdsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsByIdsRequestHandler
        extends AbstractRequestHandler<GetConversationsByIdsRequest,GetConversationsByIdsResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "get_conversations_by_ids";
    }

    @Override
    public Response<GetConversationsByIdsResponse> doHandle(Request<GetConversationsByIdsRequest> msg) {
        // todo implement later


        //
        return null;
    }
}
