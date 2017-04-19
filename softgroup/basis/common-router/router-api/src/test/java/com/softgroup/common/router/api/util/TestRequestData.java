package com.softgroup.common.router.api.util;

import com.softgroup.common.protocol.RequestData;

/**
 * @author AlexKazmirchuk
 * @since 14.04.17.
 */

public class TestRequestData implements RequestData {

    private String name;
    private String phone;
    private String otherData;

    public TestRequestData(String name, String phone, String otherData) {
        this.name = name;
        this.phone = phone;
        this.otherData = otherData;
    }

    public TestRequestData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }
}
