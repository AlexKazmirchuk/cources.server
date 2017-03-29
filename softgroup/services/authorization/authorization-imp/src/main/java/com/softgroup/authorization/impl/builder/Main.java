package com.softgroup.authorization.impl.builder;

import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;

/**
 * @author AlexKazmirchuk
 * @since 28.03.17.
 */
public class Main {
    public static void main(String[] args) {
        RegisterResponse registerResponse = new RegisterResponse();
        ActionHeader header = new ActionHeader();
        ResponseStatus status = new ResponseStatus();

        Response<RegisterResponse> response = new Response.ResponseBuilder<RegisterResponse>()
                .setHeader(header)
                .setData(registerResponse)
                .setStatus(status)
                .build();

    }
}
