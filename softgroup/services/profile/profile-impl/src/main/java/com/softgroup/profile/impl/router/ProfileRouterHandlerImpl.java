package com.softgroup.profile.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.api.router.ProfileRouterHandler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

@Component
public class ProfileRouterHandlerImpl
        extends AbstractRouterHandler<ProfileRequestHandler>
        implements ProfileRouterHandler {

    @Override
    public String getName() {
        return "profile";
    }
}
