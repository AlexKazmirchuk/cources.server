package com.softgroup.common.validation;

import com.softgroup.common.exceptions.InvalidRequestException;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.validation.configuration.RequestValidationServiceAppCfg;
import com.softgroup.common.validation.impl.RequestValidationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author AlexKazmirchuk
 * @since 07.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RequestValidationServiceAppCfg.class})
public class RequestValidationServiceTest {

    @Autowired
    private RequestValidationServiceImpl requestValidationService;

    @Test
    public void validateCorrectRequestTest() throws InvalidRequestException {
        ActionHeader correctHeader = ActionHeader.newBuilder()
                .setType("authorization").setCommand("login").setVersion("1.0")
                .setUuid("6fbc6af7-f6e7-473f-9f46-508906f52bf7").build();
        Request correctRequest = new Request(correctHeader,null);

        requestValidationService.validateRequest(correctRequest);
    }

    @Test(expected = InvalidRequestException.class)
    public void validateBadRequestTest() throws InvalidRequestException {
        ActionHeader badHeader = ActionHeader.newBuilder()
                .setType("badType").setCommand("wrongCommand").setVersion("Hk8")
                .setUuid("690af7-f6e7-473f-990f7").build();
        Request badRequest = new Request(badHeader,null);

        requestValidationService.validateRequest(badRequest);
    }

    @Test(expected = InvalidRequestException.class)
    public void validateRequestWithNullHeaderTest() throws InvalidRequestException {
        Request badRequest = new Request(null,null);
        requestValidationService.validateRequest(badRequest);
    }

    @Test(expected = InvalidRequestException.class)
    public void validateRequestWithNullHeaderValuesTest() throws InvalidRequestException {
        ActionHeader withNullValuesHeader = ActionHeader.newBuilder()
                .setCommand("register").setVersion("1.0").build();
        Request badRequest = new Request(withNullValuesHeader,null);
        requestValidationService.validateRequest(badRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateMethodTestWithNullParameter() throws InvalidRequestException {
        requestValidationService.validateRequest(null);
    }

}
