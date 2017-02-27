package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.profile.api.dto.ProfileSettingsDTO;

/**
 * Created by sasha on 24.02.17.
 */
public class SetProfileSettingsRequest implements RequestData {

    private static final long serialVersionUID = -3668172891070371522L;

    private ProfileSettingsDTO settings;

    public ProfileSettingsDTO getSettings() {
        return settings;
    }

    public void setSettings(ProfileSettingsDTO settings) {
        this.settings = settings;
    }
}
