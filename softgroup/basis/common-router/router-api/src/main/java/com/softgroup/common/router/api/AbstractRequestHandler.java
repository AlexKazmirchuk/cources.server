package com.softgroup.common.router.api;

import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.*;
import com.softgroup.common.protocol.factories.RequestFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractRequestHandler
		<T extends RequestData, R extends ResponseData>
		implements RequestHandler {

	@Autowired
	private DataMapper mapper;

	private final Class<T> genericClass = (Class<T>) ((ParameterizedType) this.getClass()
			.getGenericSuperclass())
			.getActualTypeArguments()[0];


	@Override
	public Response<R> handle(Request<?> msg) {
		Request<T> request = RequestFactory.createRequest(msg.getHeader(),
				mapper.convert(msg.getData(), genericClass));
		return doHandle(request);
	}

	public abstract Response<R> doHandle(Request<T> msg);

}
