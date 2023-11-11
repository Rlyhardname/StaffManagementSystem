package com.sirma.internal.staffmanagementsystem.management.interfaces;

import com.sirma.internal.staffmanagementsystem.management.model.Employee;

import java.util.List;

public interface CustomReader {
    List<Employee> read(String uri);
}
