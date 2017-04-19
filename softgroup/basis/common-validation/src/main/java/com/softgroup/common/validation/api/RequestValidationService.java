package com.softgroup.common.validation.api;

import com.softgroup.common.exceptions.InvalidRequestException;
import com.softgroup.common.protocol.Request;

/**
 * @author AlexKazmirchuk
 * @since 06.04.17.
 */
public interface RequestValidationService {

    void validateRequest(Request<?> request) throws InvalidRequestException;

}
