package com.sirma.internal.staffmanagementsystem.management.interfaces;

import com.sirma.internal.staffmanagementsystem.management.model.Employee;

import java.util.List;

public interface CustomWriter {
    void write(String uri, List<Employee> employees);
}
