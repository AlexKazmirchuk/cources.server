package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ProfileStatusDTO;

import java.util.List;

/**
 * Created by sasha on 24.02.17.
 */
public class GetLastTimeOnlineResponse implements ResponseData {

    private static final long serialVersionUID = -5712064427245589902L;

    private List<ProfileStatusDTO> profiles;

    public List<ProfileStatusDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileStatusDTO> profiles) {
        this.profiles = profiles;
    }
}
