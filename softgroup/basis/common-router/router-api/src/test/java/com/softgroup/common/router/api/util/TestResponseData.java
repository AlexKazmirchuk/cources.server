package com.softgroup.common.router.api.util;

import com.softgroup.common.protocol.ResponseData;

/**
 * @author AlexKazmirchuk
 * @since 14.04.17.
 */

public class TestResponseData implements ResponseData {

    private String name;
    private String phone;
    private String otherData;

    public TestResponseData(String name, String phone, String otherData) {
        this.name = name;
        this.phone = phone;
        this.otherData = otherData;
    }

    public TestResponseData(TestRequestData testRequestData) {
        this.name = testRequestData.getName();
        this.phone = testRequestData.getPhone();
        this.otherData = testRequestData.getOtherData();
    }

    public TestResponseData() {
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
