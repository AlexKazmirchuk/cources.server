package com.softgroup.common.router.api;

import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.util.TestRequestData;
import com.softgroup.common.router.api.util.TestResponseData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * @author AlexKazmirchuk
 * @since 14.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonRouterApiCfgIT.class, DataMapperAppCfg.class})
public class AbstractRequestHandlerTest {

    @Autowired
    private AbstractRequestHandler<TestRequestData,TestResponseData> testRequestHandler;

    private AbstractRequestHandler<TestRequestData,TestResponseData> spiedTestRequestHandler;

    @Before
    public void init(){
        spiedTestRequestHandler = spy(testRequestHandler);
    }

    @Test
    public void checkIfNotNull(){
        assertThat(testRequestHandler,notNullValue());
        assertThat(spiedTestRequestHandler,notNullValue());
    }

    @Test
    public void handleMethodWithCorrectRequestTest(){
        HashMap<String,String> data = new HashMap<>();
        data.put("name", "John Doe");
        data.put("phone", "5993-0485-9304");
        data.put("other_data", "some other info");

        Request<?> request = new Request<>(new ActionHeader(),data);
        Response<TestResponseData> response = spiedTestRequestHandler.handle(request);

        assertThat(response, notNullValue());
        assertThat(response.getHeader(), notNullValue());
        assertThat(response.getData(), notNullValue());
        assertThat(response.getData(), instanceOf(TestResponseData.class));

        assertThat(response.getData().getName(), is("John Doe"));
        assertThat(response.getData().getPhone(), is("5993-0485-9304"));
        assertThat(response.getData().getOtherData(), is("some other info"));

        verify(spiedTestRequestHandler).handle(request);
        verify(spiedTestRequestHandler).doHandle(any());
    }

    @Test
    public void handleMethodWithNotCorrectDataNamesTest(){
        HashMap<String,String> data = new HashMap<>();
        data.put("some_other_key", "John Doe");
        data.put("Bla_bla bla", "5993-0485-9304");
        data.put("other_data", "some other info");
        data.put("test_key", "some other info");

        Request<?> request = new Request<>(new ActionHeader(),data);
        Response<TestResponseData> response = spiedTestRequestHandler.handle(request);

        assertThat(response, notNullValue());
        assertThat(response.getHeader(), notNullValue());
        assertThat(response.getData(), notNullValue());
        assertThat(response.getData(), instanceOf(TestResponseData.class));

        assertThat(response.getData().getName(), nullValue());
        assertThat(response.getData().getPhone(), nullValue());
        assertThat(response.getData().getOtherData(), is("some other info"));

        verify(spiedTestRequestHandler).handle(request);
        verify(spiedTestRequestHandler).doHandle(any());
    }

    @Test
    public void handleMethodWithNoValuesToMapDataTest(){
        HashMap<String,String> data = new HashMap<>();

        Request<?> request = new Request<>(new ActionHeader(),data);
        Response<TestResponseData> response = spiedTestRequestHandler.handle(request);

        assertThat(response, notNullValue());
        assertThat(response.getHeader(), notNullValue());
        assertThat(response.getData(), notNullValue());
        assertThat(response.getData(), instanceOf(TestResponseData.class));

        assertThat(response.getData().getName(), nullValue());
        assertThat(response.getData().getPhone(), nullValue());
        assertThat(response.getData().getOtherData(), nullValue());

        verify(spiedTestRequestHandler).handle(request);
        verify(spiedTestRequestHandler).doHandle(any());
    }


}
