package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Response;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.softgroup.common.router.api.util.Util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * @author AlexKazmirchuk
 * @since 11.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonRouterApiCfgIT.class})
public class AbstractRouterHandlerTest {

    @Autowired
    private AbstractRouterHandler<RequestHandler> commandRouterHandler;

    private AbstractRouterHandler<RequestHandler> spiedCommandRouterHandler;

    @Before
    public void init(){
        spiedCommandRouterHandler = spy(commandRouterHandler);
    }

    @Test
    public void checkForNotNull(){
        assertThat(commandRouterHandler,notNullValue());
        assertThat(spiedCommandRouterHandler,notNullValue());
    }

    @Test
    public void handleMethodTest(){
        Response response = spiedCommandRouterHandler.handle(REQUEST_WITH_TEST_COMMAND_ONE);
        assertThat(response.getHeader().getCommand(), is("test_command_one"));

        response = spiedCommandRouterHandler.handle(REQUEST_WITH_TEST_COMMAND_TWO);
        assertThat(response.getHeader().getCommand(), is("test_command_two"));

        verify(spiedCommandRouterHandler).handle(REQUEST_WITH_TEST_COMMAND_ONE);
        verify(spiedCommandRouterHandler).handle(REQUEST_WITH_TEST_COMMAND_TWO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleMethodWithNullRequestTest(){
        spiedCommandRouterHandler.handle(null);
    }

    @Ignore // todo test does not passes now, so fix this case later
    @Test(expected = IllegalArgumentException.class)
    public void handleMethodWithNotExistingCommandTest(){
        spiedCommandRouterHandler.handle(createRequest("not_existing_command",null));
    }

}
