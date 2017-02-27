package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.UpdateConversationSettingsRequest;
import com.softgroup.messenger.api.message.UpdateConversationSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * @author AlexKazmirchuk
 * @since 26.02.17.
 */

public class UpdateConversationSettingsRequestHandler
        extends AbstractRequestHandler<UpdateConversationSettingsRequest,UpdateConversationSettingsResponse>
        implements MessengerRequestHandler {

    @Override
    public String getName() {
        return "create_conversation";
    }

    @Override
    public Response<UpdateConversationSettingsResponse> doHandle(Request<UpdateConversationSettingsRequest> msg) {
        // todo implement later


        //
        return null;
    }
}

