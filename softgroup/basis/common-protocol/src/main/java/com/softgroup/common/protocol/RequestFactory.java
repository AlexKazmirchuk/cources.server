package com.softgroup.common.protocol;

/**
 * @author AlexKazmirchuk
 * @since 29.03.17.
 */
public class RequestFactory {

    public static <T extends RequestData> Request<T> createRequest(ActionHeader header, T data){
        return new Request.RequestBuilder<T>()
                .setHeader(header)
                .setData(data)
                .build();
    }

}
