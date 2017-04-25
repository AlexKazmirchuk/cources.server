package com.softgroup.common.router.impl.test;

import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.impl.FirstRouter;
import com.softgroup.common.router.impl.configuration.FirstRouterAppCfg;
import com.softgroup.common.router.impl.test.configuration.RouterImplAppCfgTest;
import com.softgroup.common.router.impl.test.message.TestResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author AlexKazmirchuk
 * @since 28.02.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FirstRouterAppCfg.class,
                                 RouterImplAppCfgTest.class,
                                 DataMapperAppCfg.class})
public class FirstRouterAppCfgIT {

    @Autowired
    private FirstRouter firstRouter;

    private Request<LinkedHashMap<String,String>> firstRequest;
    private Request<LinkedHashMap<String,String>> secondRequest;
    private Request<LinkedHashMap<String,String>> thirdRequest;
    private Request<LinkedHashMap<String,String>> forthRequest;
    private Request<LinkedHashMap<String,String>> requestWithWrongType;
    private Request<LinkedHashMap<String,String>> requestWithWrongCommand;

    @Before
    public void initRequests(){

        ActionHeader firstHeader = new ActionHeader();
        firstHeader.setVersion("0.1");
        firstHeader.setType("first_type");
        firstHeader.setCommand("first_test_request_handler");
        firstHeader.setUuid("134-34546-657586");

        LinkedHashMap<String,String> firstMap = new LinkedHashMap<>();
        firstMap.put("request_value", "some value");

        firstRequest = new Request<>();
        firstRequest.setHeader(firstHeader);
        firstRequest.setData(firstMap);

        ActionHeader secondHeader = new ActionHeader();
        secondHeader.setVersion("0.1");
        secondHeader.setType("first_type");
        secondHeader.setCommand("second_test_request_handler");
        secondHeader.setUuid("134-34546-657586");

        LinkedHashMap<String,String> secondMap = new LinkedHashMap<>();
        secondMap.put("request_value", "another test value");

        secondRequest = new Request<>();
        secondRequest.setHeader(secondHeader);
        secondRequest.setData(secondMap);

        ActionHeader thirdHeader = new ActionHeader();
        thirdHeader.setVersion("0.1");
        thirdHeader.setType("second_type");
        thirdHeader.setCommand("third_test_request_handler");
        thirdHeader.setUuid("134-34546-657586");

        LinkedHashMap<String,String> thirdMap = new LinkedHashMap<>();
        thirdMap.put("request_value", "again another test value");

        thirdRequest = new Request<>();
        thirdRequest.setHeader(thirdHeader);
        thirdRequest.setData(thirdMap);

        ActionHeader forthHeader = new ActionHeader();
        forthHeader.setVersion("0.1");
        forthHeader.setType("second_type");
        forthHeader.setCommand("forth_test_request_handler");
        forthHeader.setUuid("134-34546-657586");

        LinkedHashMap<String,String> forthMap = new LinkedHashMap<>();
        forthMap.put("request_value", "last test value");

        forthRequest = new Request<>();
        forthRequest.setHeader(forthHeader);
        forthRequest.setData(forthMap);

        ActionHeader headerWithWrongType = new ActionHeader();
        headerWithWrongType.setUuid("3434-45-65-65657");
        headerWithWrongType.setVersion("0.1");
        headerWithWrongType.setCommand("first_test_request_handler");
        headerWithWrongType.setType("wrong_type");

        LinkedHashMap<String,String> someData = new LinkedHashMap<>();
        someData.put("request_value", "some info");

        requestWithWrongType = new Request<>();
        requestWithWrongType.setHeader(headerWithWrongType);
        requestWithWrongType.setData(someData);

        ActionHeader headerWithWrongCommand = new ActionHeader();
        headerWithWrongCommand.setUuid("3434-45-65-65657");
        headerWithWrongCommand.setVersion("0.1");
        headerWithWrongCommand.setCommand("wrong_command");
        headerWithWrongCommand.setType("first_type");

        LinkedHashMap<String,String> data = new LinkedHashMap<>();
        data.put("request_value", "info");

        requestWithWrongCommand = new Request<>();
        requestWithWrongCommand.setHeader(headerWithWrongCommand);
        requestWithWrongCommand.setData(data);

    }

    @Test
    public void test(){
        assertThat(firstRouter, CoreMatchers.notNullValue());
        assertEquals(FirstRouter.class, firstRouter.getClass());
    }

    @Test
    public void testFirstRequest(){
        String expectedResult = "response from first_test_request_handler some value";

        Response<?> response = firstRouter.handle(firstRequest);
        TestResponse responseData = (TestResponse) response.getData();

        assertEquals(expectedResult, responseData.getResponseValue());
    }

    @Test
    public void testSecondRequest(){
        String expectedResult = "response from second_test_request_handler another test value";

        Response<?> response = firstRouter.handle(secondRequest);
        TestResponse responseData = (TestResponse) response.getData();

        assertEquals(expectedResult, responseData.getResponseValue());
    }

    @Test
    public void testThirdRequest(){
        String expectedResult = "response from third_test_request_handler again another test value";

        Response<?> response = firstRouter.handle(thirdRequest);
        TestResponse responseData = (TestResponse) response.getData();

        assertEquals(expectedResult, responseData.getResponseValue());
    }

    @Test
    public void testForthRequest(){
        String expectedResult = "response from forth_test_request_handler last test value";

        Response<?> response = firstRouter.handle(forthRequest);
        TestResponse responseData = (TestResponse) response.getData();

        assertEquals(expectedResult, responseData.getResponseValue());
    }

    @Test
    @Ignore
    public void testRequestWithWrongType(){
        Integer expectedStatusCode = 422;
        String expectedStatusMessage = "Unprocessable Entity";

        Response<?> response = firstRouter.handle(requestWithWrongType);
        ResponseStatus status = response.getStatus();

        assertEquals(expectedStatusCode, status.getCode());
        assertEquals(expectedStatusMessage, status.getMessage());
    }

    @Test
    @Ignore
    public void testRequestWithWrongCommand(){
        Integer expectedStatusCode = 422;
        String expectedStatusMessage = "Unprocessable Entity";

        Response<?> response = firstRouter.handle(requestWithWrongCommand);
        ResponseStatus status = response.getStatus();

        assertEquals(expectedStatusCode, status.getCode());
        assertEquals(expectedStatusMessage, status.getMessage());
    }

    @Test
    @Ignore
    public void testHandleMethodWithNull(){
        Integer expectedStatusCode = 422;
        String expectedStatusMessage = "Unprocessable Entity";

        Response<?> response = firstRouter.handle(null);
        ResponseStatus status = response.getStatus();

        assertEquals(expectedStatusCode, status.getCode());
        assertEquals(expectedStatusMessage, status.getMessage());
    }
}
