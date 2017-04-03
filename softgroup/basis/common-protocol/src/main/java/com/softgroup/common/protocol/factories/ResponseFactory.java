package com.softgroup.common.protocol.factories;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.ResponseStatus;

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
