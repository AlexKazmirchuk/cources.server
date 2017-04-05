package com.softgroup.common.protocol;

import java.io.Serializable;

public class Response<T extends Serializable> extends RoutedAction<T> {
	private static final long serialVersionUID = 8979170551734666755L;

	private ResponseStatus status;

	public Response() {
	}

	public Response(ActionHeader header, T data,ResponseStatus status) {
		setHeader(header);
		setData(data);
		this.status = status;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public static class ResponseBuilder<T extends ResponseData> {

		private ActionHeader header;
		private T data;
		private ResponseStatus status;

		public ResponseBuilder(){

		}

		public ResponseBuilder<T> setHeader(ActionHeader header){
			this.header = header;
			return this;
		}

		public ResponseBuilder<T> setData(T data){
			this.data = data;
			return this;
		}

		public ResponseBuilder<T> setStatus(ResponseStatus status){
			this.status = status;
			return this;
		}

		public ResponseBuilder<T> setOkStatus(){
			status = ResponseStatus.OK;
			return this;
		}

		public Response<T> build(){
			return new Response<>(header,data,status);
		}
	}
}
