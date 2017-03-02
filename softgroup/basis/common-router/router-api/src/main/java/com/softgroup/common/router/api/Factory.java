package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;

/**
 * @author AlexKazmirchuk
 * @since 27.02.17.
 */

public interface Factory<T extends Handler> {

    String getRouteKey(Request<?> msg);

    T getHandler(Request<?> msg);
}
