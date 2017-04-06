package com.softgroup.common.protocol.factories;

import com.softgroup.common.protocol.*;

/**
 * @author AlexKazmirchuk
 * @since 03.04.17.
 */

public class MessageFactory {

    public static<T extends ResponseData> Response<T> createResponse(Request request, T responseData){
        return ResponseFactory.createResponse(
                ActionHeaderFactory.createHeader(request.getHeader())
                ,responseData);
    }

    public static <T extends ResponseData> Response<T> createResponse(Request request, ResponseStatusType statusType){
        return ResponseFactory.createResponse(
                        ActionHeaderFactory.createHeader(request.getHeader())
                        ,new ResponseStatus(statusType.getCode(), statusType.getMessage()));
    }

    public static <T extends ResponseData> Response<T> createResponse(Request request, Integer statusCode, String statusMessage){
        return ResponseFactory.createResponse(
                ActionHeaderFactory.createHeader(request.getHeader())
                ,new ResponseStatus(statusCode, statusMessage));
    }
}
