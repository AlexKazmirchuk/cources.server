package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.MessagesReadConfirmationRequest;
import com.softgroup.messenger.api.message.MessagesReadConfirmationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class MessagesReadConfirmationRequestHandler
        extends AbstractRequestHandler<MessagesReadConfirmationRequest,MessagesReadConfirmationResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "create_conversation";
    }

    @Override
    public Response<MessagesReadConfirmationResponse> doHandle(Request<MessagesReadConfirmationRequest> msg) {
        // todo implement later


        //
        return null;
    }
}

