package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationSettingsRequest;
import com.softgroup.messenger.api.message.GetConversationSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

@Component
public class GetConversationSettingsRequestHandler
        extends AbstractRequestHandler<GetConversationSettingsRequest,GetConversationSettingsResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "get_conversation_settings";
    }

    @Override
    public Response<GetConversationSettingsResponse> doHandle(Request<GetConversationSettingsRequest> msg) {
        // todo implement later


        //
        return null;
    }
}
