package com.softgroup.common.router.impl.test.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.impl.test.message.TestRequest;
import com.softgroup.common.router.impl.test.message.TestResponse;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 02.03.17.
 */

@Component
public class FirstTestRequestHandler
        extends AbstractRequestHandler<TestRequest,TestResponse>
        implements FirstMarkerI {

    @Override
    public String getName() {
        return "first_test_request_handler";
    }

    @Override
    public Response<TestResponse> doHandle(Request<TestRequest> msg) {

        return null;
    }
}
