package com.softgroup.common.exceptions;

/**
 * @author AlexKazmirchuk
 * @since 06.04.17.
 */
public class InvalidRequestException extends Exception {

    public InvalidRequestException(String s) {
        super(s);
    }

    public InvalidRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
