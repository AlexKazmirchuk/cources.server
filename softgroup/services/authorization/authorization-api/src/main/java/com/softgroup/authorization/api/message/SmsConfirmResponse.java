package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by sasha on 23.02.17.
 */
public class SmsConfirmResponse implements ResponseData {
    private static final long serialVersionUID = 4895238817730981751L;

    private String deviceToken;

    public SmsConfirmResponse(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public SmsConfirmResponse() {
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
