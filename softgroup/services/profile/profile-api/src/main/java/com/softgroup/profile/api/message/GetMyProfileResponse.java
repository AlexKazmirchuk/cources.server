package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ProfileDTO;

/**
 * Created by sasha on 24.02.17.
 */
public class GetMyProfileResponse implements ResponseData {

    private static final long serialVersionUID = 5817116022495809906L;

    private ProfileDTO profile;

    public GetMyProfileResponse(ProfileDTO profile) {
        this.profile = profile;
    }

    public GetMyProfileResponse() {
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }
}
