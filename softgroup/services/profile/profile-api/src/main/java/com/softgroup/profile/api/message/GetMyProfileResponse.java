package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.model.Profile;

/**
 * Created by sasha on 24.02.17.
 */
public class GetMyProfileResponse implements ResponseData {

    private static final long serialVersionUID = 5817116022495809906L;

    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
