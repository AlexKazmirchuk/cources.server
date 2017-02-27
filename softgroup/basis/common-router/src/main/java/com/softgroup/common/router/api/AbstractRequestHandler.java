package com.softgroup.common.router.api;

import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

public abstract class AbstractRequestHandler
		<T extends RequestData, R extends ResponseData>
		implements RequestHandler {

	@Override
	public Response<R> handle(Request<?> msg) {
		Request<T> request = new Request<>();
		request.setHeader(msg.getHeader());

		// todo check if working in future
		Class<T> genericClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
		JacksonDataMapper mapper = new JacksonDataMapper();
		request.setData(mapper.convert((Map<String, Object>) msg.getData(), genericClass));

		return doHandle(request);
	}

	public abstract Response<R> doHandle(Request<T> msg);

}
