package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.MessagesReadConfirmationRequest;
import com.softgroup.messenger.api.message.MessagesReadConfirmationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

@Component
public class MessagesReadConfirmationRequestHandler
        extends AbstractRequestHandler<MessagesReadConfirmationRequest,MessagesReadConfirmationResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "messages_read_confirmation";
    }

    @Override
    public Response<MessagesReadConfirmationResponse> doHandle(Request<MessagesReadConfirmationRequest> msg) {
        // todo implement later


        //
        return null;
    }
}

