package com.softgroup.common.protocol.factories;

import com.softgroup.common.protocol.*;

/**
 * @author AlexKazmirchuk
 * @since 29.03.17.
 */

public class ResponseFactory {

    public static <T extends ResponseData> Response<T> createResponse(ActionHeader header, T data){
        return new Response.ResponseBuilder<T>()
                .setHeader(header)
                .setData(data)
                .setStatus(ResponseStatus.OK)
                .build();
    }

    public static <T extends ResponseData> Response<T> createResponse(ActionHeader header, ResponseStatus status){
        return new Response.ResponseBuilder<T>()
                .setHeader(header)
                .setStatus(status)
                .build();
    }
}
