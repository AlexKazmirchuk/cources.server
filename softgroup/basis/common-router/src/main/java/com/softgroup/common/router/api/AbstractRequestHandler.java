package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;

public abstract class AbstractRequestHandler
		<T extends RequestData, R extends ResponseData>
		implements RequestHandler {

	@Override
	public Response<R> handle(Request<?> msg) {
		Request<T> request = new Request<>();
		request.setHeader(msg.getHeader());

		////////////////////////
//		Class thisClass = AbstractRequestHandler.class;
//		ParameterizedType type = (ParameterizedType) thisClass.getGenericSuperclass();
//		Class parameter = (Class) type.getActualTypeArguments()[0];
//
//		JacksonDataMapper mapper = new JacksonDataMapper();
//		request.setData(mapper.convert((Map<String, Object>) msg.getData(), (Class<T>) parameter));
		////////////////////////

		return doHandle(request);
	}

	public abstract Response<R> doHandle(Request<T> msg);

}
