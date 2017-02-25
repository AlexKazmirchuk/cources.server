package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.ContactsSyncRequest;
import com.softgroup.profile.api.message.ContactsSyncResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class ContactsSyncRequestHandler
        extends AbstractRequestHandler<ContactsSyncRequest,ContactsSyncResponse>
        implements ProfileRequestHandler {

    @Override
    public String getName() {
        return "contacts_sync";
    }

    @Override
    public Response<ContactsSyncResponse> doHandle(Request<ContactsSyncRequest> msg) {
        // implement later


        //
        return null;
    }
}
