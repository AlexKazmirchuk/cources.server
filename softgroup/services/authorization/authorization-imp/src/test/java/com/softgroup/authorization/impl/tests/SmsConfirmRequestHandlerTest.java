package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.handler.SmsConfirmRequestHandler;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.services.ProfileService;
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
public class SmsConfirmRequestHandlerTest {

    @Autowired
    private SmsConfirmRequestHandler smsConfirmRequestHandler;

    @Test
    public void checkIfNotNull(){
        assertThat(smsConfirmRequestHandler, notNullValue());
    }

}
