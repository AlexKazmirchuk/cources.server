package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationDetailsRequestHandler
        extends AbstractRequestHandler<GetConversationDetailsRequest,GetConversationDetailsResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "create_conversation";
    }

    @Override
    public Response<GetConversationDetailsResponse> doHandle(Request<GetConversationDetailsRequest> msg) {
        // implement later


        //
        return null;
    }
}

