package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class GetContactProfilesRequestHandler
        extends AbstractRequestHandler<GetContactProfilesRequest,GetContactProfilesResponse>
        implements ProfileRequestHandler {

    @Override
    public String getName() {
        return "get_contact_profiles";
    }

    @Override
    public Response<GetContactProfilesResponse> handle(Request<?> msg) {
        // implement later


        //
        return null;
    }
}
