package com.softgroup.common.model.mapper.models;

/**
 * @author AlexKazmirchuk
 * @since 31.03.17.
 */
public class TestPerson {

    private String name;
    private String lastName;
    private TestAddress address;
    private int age;

    public TestPerson(String name, String lastName, int age, TestAddress address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    public TestPerson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TestAddress getAddress() {
        return address;
    }

    public void setAddress(TestAddress address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
