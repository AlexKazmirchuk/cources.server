package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;

public interface RouterHandler{

	String getRouteKey(final Request<?> msg);
}
