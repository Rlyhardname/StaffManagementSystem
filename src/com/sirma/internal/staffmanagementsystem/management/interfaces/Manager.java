package com.sirma.internal.staffmanagementsystem.management.interfaces;

import com.sirma.internal.staffmanagementsystem.management.model.Employee;

import java.util.Scanner;

public interface Manager {

    void exitApp();

    void addEmployee(Employee employee);

    void editEmployee(long id, Scanner sc);

    void fireEmployee(long id);

    void listEmployees();

    void execute(String command, Scanner sc);
}
