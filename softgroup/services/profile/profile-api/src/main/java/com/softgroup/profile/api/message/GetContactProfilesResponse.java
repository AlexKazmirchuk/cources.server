package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ProfileDTO;

import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

public class GetContactProfilesResponse implements ResponseData {

    private static final long serialVersionUID = 7182031214980471450L;

    private List<ProfileDTO> profiles;

    public GetContactProfilesResponse(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }

    public GetContactProfilesResponse() {
    }

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }
}
