package com.hr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a company department.
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int id;
    private String name;
    private String location;
    private Employee head;
    private final List<Employee> employees = new ArrayList<>();

    public Department(int id, String name, String location) {
        if(name == null || location == null) {
            throw new IllegalArgumentException("Department details cannot be null");
        }
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) throw new IllegalArgumentException("name");
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if(location == null) throw new IllegalArgumentException("location");
        this.location = location;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        if(head != null && !employees.contains(head)) {
            throw new IllegalArgumentException("Head must be member of department");
        }
        this.head = head;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee e) {
        if(e == null) throw new IllegalArgumentException("employee");
        if(!employees.contains(e)) {
            employees.add(e);
            e.setDepartment(this);
        }
    }

    public void removeEmployee(Employee e) {
        if(e == null) throw new IllegalArgumentException("employee");
        employees.remove(e);
        if(e.getDepartment() == this) {
            e.setDepartment(null);
        }
        if(head == e) {
            head = null;
        }
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
