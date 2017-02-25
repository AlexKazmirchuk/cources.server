package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetProfileSettingsRequest;
import com.softgroup.profile.api.message.GetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class GetProfileSettingsRequestHandler
        extends AbstractRequestHandler<GetProfileSettingsRequest,GetProfileSettingsResponse>
        implements ProfileRequestHandler {
    @Override
    public String getName() {
        return "get_profile_settings";
    }

    @Override
    public Response<GetProfileSettingsResponse> doHandle(Request<GetProfileSettingsRequest> msg) {
        // implement later


        //
        return null;
    }
}
