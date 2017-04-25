package com.softgroup.common.router.impl.test.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.impl.test.message.TestRequest;
import com.softgroup.common.router.impl.test.message.TestResponse;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 02.03.17.
 */

@Component
public class ForthTestRequestHandler extends AbstractRequestHandler<TestRequest,TestResponse>
        implements SecondMarkerI {

    @Override
    public String getName() {
        return "forth_test_request_handler";
    }

    @Override
    public Response<TestResponse> doHandle(Request<TestRequest> msg) {
        // set response header
        Response<TestResponse> response = new Response<>();
        response.setHeader(msg.getHeader());
        response.getHeader().setOriginUuid(response.getHeader().getUuid());

        // set response data
        TestResponse testResponse = new TestResponse();
        testResponse.setResponseValue("response from " + getName() + " " +  msg.getData().getRequestValue());
        response.setData(testResponse);

        // set response status
        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");
        response.setStatus(status);

        return response;
    }
}
