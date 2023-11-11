package com.sirma.internal.staffmanagementsystem.management.interfaces;

import com.sirma.internal.staffmanagementsystem.management.enums.Department;
import com.sirma.internal.staffmanagementsystem.management.model.Employee;

import java.util.Scanner;

public interface Manager {

    void exitApp();

    void addEmployee(Employee employee);

    void editEmployee(long id, Scanner sc);

    void fireEmployee(long id);

    void listEmployees();

    void execute(String command, Scanner sc);

    Employee search(long id);

    Employee search(String name);

    Employee search(Department department);
}
