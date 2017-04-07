package com.softgroup.common.router.api;

import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.exceptions.MapperException;
import com.softgroup.common.protocol.*;
import com.softgroup.common.protocol.factories.MessageFactory;
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
		T requestData;
		Request<T> request;
		try {
			requestData = mapper.convert(msg.getData(), genericClass);
			request = MessageFactory.createRequest(msg.getHeader(),requestData);
		} catch (MapperException e){
			return MessageFactory.createResponse(msg,ResponseStatusType.BAD_REQUEST);
		}
		return doHandle(request);
	}

	public abstract Response<R> doHandle(Request<T> msg);

}
