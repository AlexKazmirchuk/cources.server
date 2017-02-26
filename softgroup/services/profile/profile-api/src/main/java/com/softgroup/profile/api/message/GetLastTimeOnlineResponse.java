package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.model.ProfileStatus;

import java.util.List;

/**
 * Created by sasha on 24.02.17.
 */
public class GetLastTimeOnlineResponse implements ResponseData {

    private static final long serialVersionUID = -5712064427245589902L;

    private List<ProfileStatus> profiles;

    public List<ProfileStatus> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileStatus> profiles) {
        this.profiles = profiles;
    }
}
