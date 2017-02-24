package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetMyProfileRequest;
import com.softgroup.profile.api.message.SetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class SetMyProfileRequestHandler
        extends AbstractRequestHandler<SetMyProfileRequest,SetMyProfileResponse>
        implements ProfileRequestHandler {

    @Override
    public String getName() {
        return "set_my_profile";
    }

    @Override
    public Response<SetMyProfileResponse> handle(Request<?> msg) {
        // implement later


        //
        return null;
    }
}
