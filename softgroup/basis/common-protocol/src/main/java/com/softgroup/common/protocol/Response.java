package com.softgroup.common.protocol;

import java.io.Serializable;

public class Response<T extends Serializable> extends RoutedAction<T> {
	private static final long serialVersionUID = 8979170551734666755L;

	private ResponseStatus status;

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
			status = new ResponseStatus();
			status.setCode(200);
			status.setMessage("OK");
			return this;
		}

		public Response<T> build(){
			Response response = new Response();
			response.setHeader(header);
			response.setData(data);
			response.setStatus(status);
			return response;
		}
	}
}
