package com.softgroup.common.router.api.util;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;

/**
 * @author AlexKazmirchuk
 * @since 11.04.17.
 */

public class Util {
    public static Request<?> createRequest(String command, String type){
        ActionHeader header = ActionHeader.newBuilder()
                .setCommand(command)
                .setType(type)
                .build();
        return new Request<>(header,null);
    }

    public static Response createResponse(String command, String type){
        ActionHeader header = ActionHeader.newBuilder()
                .setCommand(command)
                .setType(type)
                .build();
        return new Response(header,null,null);
    }
}
