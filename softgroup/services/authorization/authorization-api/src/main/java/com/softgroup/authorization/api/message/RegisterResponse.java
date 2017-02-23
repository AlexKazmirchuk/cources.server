package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * @author odin
 * @since 20.02.17.
 */
public class RegisterResponse implements ResponseData {
	private static final long serialVersionUID = -5146888202653750948L;

	private Integer registrationRequestUuid;
	private Integer registrationTimeoutSec;
	private Integer authCode;

	public Integer getRegistrationRequestUuid() {
		return registrationRequestUuid;
	}

	public void setRegistrationRequestUuid(Integer registrationRequestUuid) {
		this.registrationRequestUuid = registrationRequestUuid;
	}

	public Integer getRegistrationTimeoutSec() {
		return registrationTimeoutSec;
	}

	public void setRegistrationTimeoutSec(Integer registrationTimeoutSec) {
		this.registrationTimeoutSec = registrationTimeoutSec;
	}

	public Integer getAuthCode() {
		return authCode;
	}

	public void setAuthCode(Integer authCode) {
		this.authCode = authCode;
	}
}
