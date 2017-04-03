package com.softgroup.common.protocol.factories;

import com.softgroup.common.protocol.*;

/**
 * @author AlexKazmirchuk
 * @since 03.04.17.
 */

public class MessageFactory {

    public static<T extends ResponseData> Response<T> createResponseWithOk(Request request, T responseData){
        return ResponseFactory.createResponseWithOk(
                ActionHeaderFactory.createHeader(request.getHeader())
                ,responseData);
    }

    public static <T extends ResponseData> Response<T> createResponse(Request request, T responseData, ResponseStatus status){
        return ResponseFactory.createResponse(
                        ActionHeaderFactory.createHeader(request.getHeader())
                        ,responseData
                        ,status);
    }
}
