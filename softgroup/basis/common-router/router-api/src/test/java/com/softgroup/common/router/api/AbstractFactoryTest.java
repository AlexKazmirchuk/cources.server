package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.softgroup.common.router.api.util.TestUtil.createRequest;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.*;

/**
 * @author AlexKazmirchuk
 * @since 10.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonRouterApiCfgIT.class})
public class AbstractFactoryTest {

    @Autowired
    private AbstractFactory<RequestHandler> requestHandlerFactory;

    @Autowired
    private AbstractFactory<RouterHandler> routerHandlerFactory;

    private AbstractFactory<RequestHandler> spiedRequestHandlerFactory;

    private AbstractFactory<RouterHandler> spiedRouterHandlerFactory;

    @Before
    public void init(){
        spiedRequestHandlerFactory = spy(requestHandlerFactory);
        spiedRouterHandlerFactory = spy(routerHandlerFactory);
    }

    @Test
    public void requestHandlerFactoryGetRouteKeyMethodTest(){
        assertThat(requestHandlerFactory, notNullValue());

        String routeKey = requestHandlerFactory.getRouteKey(createRequest("test_command_one",null));
        assertThat(routeKey,is("test_command_one"));
        routeKey = requestHandlerFactory.getRouteKey(createRequest("test_command_two",null));
        assertThat(routeKey,is("test_command_two"));
        routeKey = requestHandlerFactory.getRouteKey(createRequest("",null));
        assertThat(routeKey,is(""));
        routeKey = requestHandlerFactory.getRouteKey(createRequest(null,null));
        assertThat(routeKey,nullValue());
    }

    @Test
    public void routerHandlerFactoryGetRouteKeyMethodTest(){
        assertThat(routerHandlerFactory, notNullValue());

        String routeKey = routerHandlerFactory.getRouteKey(createRequest(null,"test_type_one"));
        assertThat(routeKey,is("test_type_one"));
        routeKey = routerHandlerFactory.getRouteKey(createRequest(null,"test_type_two"));
        assertThat(routeKey,is("test_type_two"));
        routeKey = routerHandlerFactory.getRouteKey(createRequest(null,""));
        assertThat(routeKey,is(""));
        routeKey = routerHandlerFactory.getRouteKey(createRequest(null,null));
        assertThat(routeKey,nullValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void requestHandlerFactoryGetRouteKeyMethodWithNullParameter(){
        requestHandlerFactory.getRouteKey(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requestHandlerFactoryGetRouteKeyMethodWithNullHeader(){
        requestHandlerFactory.getRouteKey(new Request<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void routerHandlerFactoryGetRouteKeyMethodWithNullParameter(){
        routerHandlerFactory.getRouteKey(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void routerHandlerFactoryGetRouteKeyMethodWithNullHeader(){
        routerHandlerFactory.getRouteKey(new Request<>());
    }

    @Test
    public void requestHandlerFactoryGetHandlerMethodTest(){
        RequestHandler requestHandler = requestHandlerFactory.getHandler(
                createRequest("test_command_one",null));

        assertThat(requestHandler, notNullValue());
        assertThat(requestHandler.getName(), is("test_command_one"));
        assertThat(requestHandler, instanceOf(RequestHandler.class));

        requestHandler = requestHandlerFactory.getHandler(
                createRequest("test_command_two",null));
        assertThat(requestHandler, notNullValue());
        assertThat(requestHandler.getName(), is("test_command_two"));
        assertThat(requestHandler, instanceOf(RequestHandler.class));

        requestHandler = requestHandlerFactory.getHandler(
                createRequest("not_existing_command",null));
        assertThat(requestHandler, nullValue());

        requestHandler = requestHandlerFactory.getHandler(
                createRequest(null,null));
        assertThat(requestHandler, nullValue());
    }

    @Test
    public void routerHandlerFactoryGetHandlerMethodTest(){
        RouterHandler routerHandler = routerHandlerFactory.getHandler(
                createRequest(null,"test_type_one"));

        assertThat(routerHandler, notNullValue());
        assertThat(routerHandler.getName(), is("test_type_one"));
        assertThat(routerHandler, instanceOf(RouterHandler.class));

        routerHandler = routerHandlerFactory.getHandler(
                createRequest(null,"test_type_two"));
        assertThat(routerHandler, notNullValue());
        assertThat(routerHandler.getName(), is("test_type_two"));
        assertThat(routerHandler, instanceOf(RouterHandler.class));

        routerHandler = routerHandlerFactory.getHandler(
                createRequest(null,"not_existing_type"));
        assertThat(routerHandler, nullValue());

        routerHandler = routerHandlerFactory.getHandler(
                createRequest(null,null));
        assertThat(routerHandler, nullValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void requestHandlerFactoryGetHandlerMethodWithNullRequestTest(){
        requestHandlerFactory.getHandler(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requestHandlerFactoryGetHandlerMethodWithNullHeaderTest(){
        requestHandlerFactory.getHandler(new Request<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void routerHandlerFactoryGetHandlerMethodWithNullRequestTest(){
        routerHandlerFactory.getHandler(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void routerHandlerFactoryGetHandlerMethodWithNullHeaderTest(){
        routerHandlerFactory.getHandler(new Request<>());
    }

    @Test
    public void verifyCallMethodsOnRequestHandlerFactory(){
        Request request = createRequest("test_command_one",null);
        spiedRequestHandlerFactory.getRouteKey(request);
        spiedRequestHandlerFactory.getHandler(request);
        verify(spiedRequestHandlerFactory,times(2)).getRouteKey(request);
    }

    @Test
    public void verifyCallMethodsOnRouterHandlerFactory(){
        Request request = createRequest(null,"test_type_one");
        spiedRouterHandlerFactory.getRouteKey(request);
        spiedRouterHandlerFactory.getHandler(request);
        verify(spiedRouterHandlerFactory,times(2)).getRouteKey(request);
    }
}
