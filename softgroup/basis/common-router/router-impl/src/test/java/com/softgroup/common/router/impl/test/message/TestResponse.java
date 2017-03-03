package com.softgroup.common.router.impl.test.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * @author AlexKazmirchuk
 * @since 02.03.17.
 */

public class TestResponse implements ResponseData {

    private static final long serialVersionUID = -7267628519933825687L;

    private String responseValue;

    public String getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(String responseValue) {
        this.responseValue = responseValue;
    }
}
