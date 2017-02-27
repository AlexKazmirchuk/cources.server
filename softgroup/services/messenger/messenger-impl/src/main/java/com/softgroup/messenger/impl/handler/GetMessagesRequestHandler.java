package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetMessagesRequest;
import com.softgroup.messenger.api.message.GetMessagesResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetMessagesRequestHandler
        extends AbstractRequestHandler<GetMessagesRequest,GetMessagesResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "create_conversation";
    }

    @Override
    public Response<GetMessagesResponse> doHandle(Request<GetMessagesRequest> msg) {
        // implement later


        //
        return null;
    }
}
