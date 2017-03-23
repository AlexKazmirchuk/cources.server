package com.softgroup.common.jwt.exceptions;

/**
 * @author AlexKazmirchuk
 * @since 17.03.17.
 */

public class InvalidTokenException extends Exception {

    public InvalidTokenException(String message) {
        super(message);
    }
}
