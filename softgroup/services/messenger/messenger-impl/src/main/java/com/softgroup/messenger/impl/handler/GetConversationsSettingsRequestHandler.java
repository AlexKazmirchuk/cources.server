package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsSettingsRequest;
import com.softgroup.messenger.api.message.GetConversationsSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class GetConversationsSettingsRequestHandler
        extends AbstractRequestHandler<GetConversationsSettingsRequest,GetConversationsSettingsResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "get_conversations_settings";
    }

    @Override
    public Response<GetConversationsSettingsResponse> doHandle(Request<GetConversationsSettingsRequest> msg) {
        // todo implement later


        //
        return null;
    }
}

