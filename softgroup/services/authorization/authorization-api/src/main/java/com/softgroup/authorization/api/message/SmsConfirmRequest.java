package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Created by sasha on 23.02.17.
 */
public class SmsConfirmRequest implements RequestData {
    private static final long serialVersionUID = 4895237867740981751L;

    private String authCode;
    private String registrationRequestUuid;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getRegistrationRequestUuid() {
        return registrationRequestUuid;
    }

    public void setRegistrationRequestUuid(String registrationRequestUuid) {
        this.registrationRequestUuid = registrationRequestUuid;
    }
}
