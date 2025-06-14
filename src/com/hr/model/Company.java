package com.hr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Container for departments and employees.
 */
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<Department> departments = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final AtomicInteger employeeId = new AtomicInteger(1);
    private final AtomicInteger departmentId = new AtomicInteger(1);

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Department createDepartment(String name, String location) {
        Department d = new Department(departmentId.getAndIncrement(), name, location);
        departments.add(d);
        return d;
    }

    public Employee createEmployee(String first, String last, char gender, String addr, int payScale) {
        Employee e = new Employee(employeeId.getAndIncrement(), first, last, gender, addr, payScale);
        employees.add(e);
        return e;
    }

    public void deleteDepartment(Department d) {
        if(!d.getEmployees().isEmpty()) {
            throw new IllegalStateException("Department has employees");
        }
        departments.remove(d);
    }

    public void deleteEmployee(Employee e) {
        if(e.getDepartment() != null) {
            e.getDepartment().removeEmployee(e);
        }
        employees.remove(e);
    }
}
