package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.profile.api.dto.ProfileDTO;

/**
 * Created by sasha on 24.02.17.
 */
public class SetMyProfileRequest implements RequestData {

    private static final long serialVersionUID = -3479391449795900015L;

    private ProfileDTO profile;

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }
}
