package com.softgroup.common.router.api.util;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;

/**
 * @author AlexKazmirchuk
 * @since 11.04.17.
 */

public class TestUtil {

    public static final Request<?> REQUEST_WITH_TEST_COMMAND_ONE =
            createRequest("test_command_one",null);

    public static final Request<?> REQUEST_WITH_TEST_COMMAND_TWO =
            createRequest("test_command_two",null);

    public static final Request<?> REQUEST_WITH_TEST_TYPE_ONE =
            createRequest(null,"test_type_one");

    public static final Request<?> REQUEST_WITH_TEST_TYPE_TWO =
            createRequest(null,"test_type_two");

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
