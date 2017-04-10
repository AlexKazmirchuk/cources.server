package com.softgroup.profile.api.dto;

/**
 * @author AlexKazmirchuk
 * @since 24.02.17.
 */

public class ProfileDTO {

    private String phoneNumber;
    private String name;
    private String status;
    private String avatarUri;

    public ProfileDTO(String phoneNumber, String name, String status, String avatarUri) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.status = status;
        this.avatarUri = avatarUri;
    }

    public ProfileDTO() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }
}
