package com.softgroup.common.router.impl.test.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.impl.test.handler.FirstMarkerI;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 02.03.17.
 */

@Component
public class FirstTestCommandRouter extends AbstractRouterHandler<FirstMarkerI>
        implements CommonRouterHandler {

    @Override
    public String getName() {
        return "first_command";
    }
}
