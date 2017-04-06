package com.softgroup.common.validation.impl;

import com.softgroup.common.exceptions.InvalidRequestException;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.validation.api.RequestValidationService;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 06.04.17.
 */
@Component
public class RequestValidationServiceImpl implements RequestValidationService {

    @Override
    public void validateRequest(Request<?> request) throws InvalidRequestException {
        // todo implement later
    }
}
