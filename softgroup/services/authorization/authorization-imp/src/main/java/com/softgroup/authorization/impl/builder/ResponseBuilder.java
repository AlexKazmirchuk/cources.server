package com.softgroup.authorization.impl.builder;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.ResponseStatus;

/**
 * @author AlexKazmirchuk
 * @since 28.03.17.
 */
public class ResponseBuilder<T extends ResponseData> {

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
