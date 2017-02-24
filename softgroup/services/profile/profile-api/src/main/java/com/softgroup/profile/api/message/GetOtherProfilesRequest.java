package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Created by sasha on 24.02.17.
 */
public class GetOtherProfilesRequest implements RequestData {

    private static final long serialVersionUID = 5252930461865154293L;

    private List<String> userIDs;

    public List<String> getUserIDs() {
        return userIDs;
    }

    public void setUserIDs(List<String> userIDs) {
        this.userIDs = userIDs;
    }
}
