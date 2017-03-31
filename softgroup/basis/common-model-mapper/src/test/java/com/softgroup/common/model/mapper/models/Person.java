package com.softgroup.common.model.mapper.models;

/**
 * @author AlexKazmirchuk
 * @since 31.03.17.
 */
public class Person {

    private String name;
    private String lastName;
    private Address address;
    private int age;

    public Person(String name, String lastName, int age, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    public Person() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
