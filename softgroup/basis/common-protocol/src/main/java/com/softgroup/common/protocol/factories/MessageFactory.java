package com.softgroup.common.protocol.factories;

import com.softgroup.common.protocol.*;

/**
 * @author AlexKazmirchuk
 * @since 03.04.17.
 */

public class MessageFactory {

    public static<T extends ResponseData> Response<T> createResponse(Request request, T responseData){
        return new Response.ResponseBuilder<T>()
                .setHeader(new ActionHeader(request.getHeader()))
                .setData(responseData)
                .setStatus(new ResponseStatus(ResponseStatusType.OK.getCode(), ResponseStatusType.OK.getMessage()))
                .build();
    }

    public static <T extends ResponseData> Response<T> createResponse(Request request, ResponseStatusType statusType){
        return new Response.ResponseBuilder<T>()
                .setHeader(new ActionHeader(request.getHeader()))
                .setStatus(new ResponseStatus(statusType.getCode(), statusType.getMessage()))
                .build();
    }

    public static <T extends ResponseData> Response<T> createResponse(Request request, Integer statusCode, String statusMessage){
        return new Response.ResponseBuilder<T>()
                .setHeader(new ActionHeader(request.getHeader()))
                .setStatus(new ResponseStatus(statusCode, statusMessage))
                .build();
    }
}
