package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ProfileSettingsDTO;

/**
 * Created by sasha on 24.02.17.
 */
public class GetProfileSettingsResponse implements ResponseData {

    private static final long serialVersionUID = -3218706613545361861L;

    private ProfileSettingsDTO settings;

    public ProfileSettingsDTO getSettings() {
        return settings;
    }

    public void setSettings(ProfileSettingsDTO settings) {
        this.settings = settings;
    }
}
