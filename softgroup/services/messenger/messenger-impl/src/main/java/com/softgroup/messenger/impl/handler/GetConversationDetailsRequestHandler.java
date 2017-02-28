package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

@Component
public class GetConversationDetailsRequestHandler
        extends AbstractRequestHandler<GetConversationDetailsRequest,GetConversationDetailsResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "get_conversation_details";
    }

    @Override
    public Response<GetConversationDetailsResponse> doHandle(Request<GetConversationDetailsRequest> msg) {
        // todo implement later


        //
        return null;
    }
}

