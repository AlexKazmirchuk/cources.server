package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetProfileSettingsRequest;
import com.softgroup.profile.api.message.SetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class SetProfileSettingsRequestHandler
        extends AbstractRequestHandler<SetProfileSettingsRequest,SetProfileSettingsResponse>
        implements ProfileRequestHandler {

    @Override
    public String getName() {
        return "set_profile_settings";
    }

    @Override
    public Response<SetProfileSettingsResponse> handle(Request<?> msg) {
        // implement later


        //
        return null;
    }
}
