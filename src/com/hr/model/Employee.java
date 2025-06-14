package com.hr.model;

import java.io.Serializable;

/**
 * Represents an employee within the company.
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int id;
    private String firstName;
    private String lastName;
    private char gender;
    private String address;
    private int payScale;
    private Department department;

    public Employee(int id, String firstName, String lastName, char gender, String address, int payScale) {
        if(firstName == null || lastName == null || address == null) {
            throw new IllegalArgumentException("Employee details cannot be null");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.payScale = payScale;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null) throw new IllegalArgumentException("firstName");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null) throw new IllegalArgumentException("lastName");
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null) throw new IllegalArgumentException("address");
        this.address = address;
    }

    public int getPayScale() {
        return payScale;
    }

    public void setPayScale(int payScale) {
        this.payScale = payScale;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + id + ")";
    }
}
