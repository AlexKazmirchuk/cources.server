package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.model.ProfileSettings;

/**
 * Created by sasha on 24.02.17.
 */
public class GetProfileSettingsResponse implements ResponseData {

    private static final long serialVersionUID = -3218706613545361861L;

    private ProfileSettings settings;

    public ProfileSettings getSettings() {
        return settings;
    }

    public void setSettings(ProfileSettings settings) {
        this.settings = settings;
    }
}
