package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.handler.RegisterRequestHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author AlexKazmirchuk
 * @since 18.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationAppCfgIT.class})
public class RegisterRequestHandlerTest {

    @Autowired
    private RegisterRequestHandler registerRequestHandler;

    @Test
    public void checkIfNotNull(){
        assertThat(registerRequestHandler, notNullValue());
    }

    @Test
    public void getNameMethodTest(){
        assertThat(registerRequestHandler.getName(),is("register"));
    }
}
