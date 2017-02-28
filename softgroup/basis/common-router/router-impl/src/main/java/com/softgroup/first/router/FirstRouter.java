package com.softgroup.first.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.Handler;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 27.02.17.
 */

@Component
public class FirstRouter extends AbstractRouterHandler<CommonRouterHandler>
                        implements Handler {

    @Override
    public String getName() {
        return "first_router";
    }
}
