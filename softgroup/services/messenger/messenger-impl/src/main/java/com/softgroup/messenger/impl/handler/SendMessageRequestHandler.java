package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.SendMessageRequest;
import com.softgroup.messenger.api.message.SendMessageResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

@Component
public class SendMessageRequestHandler
        extends AbstractRequestHandler<SendMessageRequest,SendMessageResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "send_message";
    }

    @Override
    public Response<SendMessageResponse> doHandle(Request<SendMessageRequest> msg) {
        // todo implement later


        //
        return null;
    }
}

