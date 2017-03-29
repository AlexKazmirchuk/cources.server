package com.softgroup.common.protocol;

import java.io.Serializable;

public class Request<T extends Serializable> extends RoutedAction<T> {
	private static final long serialVersionUID = -1024761631293962969L;

	public Request() {
	}

	public Request(ActionHeader header, T data) {
		setHeader(header);
		setData(data);
	}

	public static class RequestBuilder<T extends RequestData> {

		private ActionHeader header;
		private T data;

		public RequestBuilder(){

		}

		public RequestBuilder<T> setHeader(ActionHeader header){
			this.header = header;
			return this;
		}

		public RequestBuilder<T> setData(T data){
			this.data = data;
			return this;
		}

		public Request<T> build(){
			return new Request<>(header,data);
		}
	}
}
