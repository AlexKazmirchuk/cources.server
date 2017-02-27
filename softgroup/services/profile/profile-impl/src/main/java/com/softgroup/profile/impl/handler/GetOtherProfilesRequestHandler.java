package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetOtherProfilesRequest;
import com.softgroup.profile.api.message.GetOtherProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class GetOtherProfilesRequestHandler
        extends AbstractRequestHandler<GetOtherProfilesRequest,GetOtherProfilesResponse>
        implements ProfileRequestHandler {

    @Override
    public String getName() {
        return "get_other_profiles";
    }

    @Override
    public Response<GetOtherProfilesResponse> doHandle(Request<GetOtherProfilesRequest> msg) {
        // todo implement later


        //
        return null;
    }
}
