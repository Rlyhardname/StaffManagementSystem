package com.sirma.internal.staffmanagementsystem.management.model;

import com.sirma.internal.staffmanagementsystem.management.enums.Department;

import java.time.LocalDate;

public class Employee {
    private long Id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Department department;
    private String role;
    private double salary;

    public Employee(long id, String name, LocalDate startDate, LocalDate endDate, Department department, String role, double salary) {
        Id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " " + Id + " " + startDate + " " + endDate + " " + department + " " + role + " " + salary;
    }
}
