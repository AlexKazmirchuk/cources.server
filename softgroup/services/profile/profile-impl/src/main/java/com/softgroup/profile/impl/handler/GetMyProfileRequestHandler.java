package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetMyProfileRequest;
import com.softgroup.profile.api.message.GetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class GetMyProfileRequestHandler
        extends AbstractRequestHandler<GetMyProfileRequest,GetMyProfileResponse>
        implements ProfileRequestHandler {

    @Override
    public String getName() {
        return "get_my_profile";
    }

    @Override
    public Response<GetMyProfileResponse> doHandle(Request<GetMyProfileRequest> msg) {
        // implement later


        //
        return null;
    }
}
