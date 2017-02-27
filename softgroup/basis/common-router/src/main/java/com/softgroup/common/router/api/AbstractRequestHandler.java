package com.softgroup.common.router.api;

import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

public abstract class AbstractRequestHandler
		<T extends RequestData, R extends ResponseData>
		implements RequestHandler {

	@Autowired
	private DataMapper mapper;

	private static final Class genericClass;

	static {
		genericClass = (Class) ((ParameterizedType) AbstractRequestHandler.class
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public Response<R> handle(Request<?> msg) {
		Request<T> request = new Request<>();
		request.setHeader(msg.getHeader());

		// todo check if working in future
		request.setData(mapper.convert((Map<String, Object>) msg.getData(), (Class<T>) genericClass));

		return doHandle(request);
	}

	public abstract Response<R> doHandle(Request<T> msg);

}
