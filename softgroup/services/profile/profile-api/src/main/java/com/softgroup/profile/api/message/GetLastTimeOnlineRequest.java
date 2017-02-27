package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Created by sasha on 24.02.17.
 */
public class GetLastTimeOnlineRequest implements RequestData {

    private static final long serialVersionUID = -4479406554098022521L;

    private List<String> profiles;

    public List<String> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<String> profiles) {
        this.profiles = profiles;
    }
}
