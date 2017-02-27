package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationsDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsDetailsRequestHandler
        extends AbstractRequestHandler<GetConversationsDetailsRequest,GetConversationsDetailsResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "create_conversation";
    }

    @Override
    public Response<GetConversationsDetailsResponse> doHandle(Request<GetConversationsDetailsRequest> msg) {
        // implement later


        //
        return null;
    }
}
