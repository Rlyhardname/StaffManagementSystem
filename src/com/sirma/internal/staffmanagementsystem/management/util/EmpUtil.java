package com.sirma.internal.staffmanagementsystem.management.util;

import com.sirma.internal.staffmanagementsystem.management.enums.Department;
import com.sirma.internal.staffmanagementsystem.management.model.Employee;

import java.time.LocalDate;

public class EmpUtil {

    public static Employee parseEntry(String[] entry) {
        long id;
        String name;
        LocalDate startDate;
        LocalDate endDate;
        Department department;
        String role;
        double salary;
        try {
            id = Long.parseLong(entry[0]);
            name = entry[1];
            String[] dateOne = entry[2].split("/");
            startDate = LocalDate.of(Integer.parseInt(dateOne[0]), Integer.parseInt(dateOne[1]), Integer.parseInt(dateOne[2]));
            String[] dateTwo = entry[3].split("/");
            endDate = LocalDate.of(Integer.parseInt(dateTwo[0]), Integer.parseInt(dateTwo[1]), Integer.parseInt(dateTwo[2]));
            department = null;
            role = entry[5];
            salary = Double.parseDouble(entry[6]);
        } catch (NumberFormatException e) {
            return null;
        }

        return new Employee(id, name, startDate, endDate, department, role, salary);
    }
}
