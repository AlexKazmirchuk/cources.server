package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ProfileDTO;

import java.util.List;

/**
 * Created by sasha on 24.02.17.
 */
public class GetOtherProfilesResponse implements ResponseData {

    private static final long serialVersionUID = -4401938203944252933L;

    private List<ProfileDTO> profiles;

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }
}
