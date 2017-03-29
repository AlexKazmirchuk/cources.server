package com.softgroup.common.protocol;

/**
 * @author AlexKazmirchuk
 * @since 29.03.17.
 */
public class ResponseFactory {

    public static <T extends ResponseData> Response<T> createResponse (ActionHeader header, T data, ResponseStatus status){
        return new Response.ResponseBuilder<T>()
                .setHeader(header)
                .setData(data)
                .setStatus(status)
                .build();
    }

    public static <T extends ResponseData> Response<T> createResponseWithOk (ActionHeader header, T data){
        return new Response.ResponseBuilder<T>()
                .setHeader(header)
                .setData(data)
                .setOkStatus()
                .build();
    }
}
