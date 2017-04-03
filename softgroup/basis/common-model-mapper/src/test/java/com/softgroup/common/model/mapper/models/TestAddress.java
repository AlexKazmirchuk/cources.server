package com.softgroup.common.model.mapper.models;

/**
 * @author AlexKazmirchuk
 * @since 31.03.17.
 */
public class TestAddress {

    private String city;
    private String street;
    private String country;

    public TestAddress(String city, String street, String country) {
        this.city = city;
        this.street = street;
        this.country = country;
    }

    public TestAddress() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
