package com.sirma.internal.staffmanagementsystem.management.interfaces;

import com.sirma.internal.staffmanagementsystem.management.model.Employee;

import java.util.Scanner;

public interface Manager {

    void exitApp();

    void addEmployee(Employee employee);

    void editEmployee(int id, Scanner sc);

    void fireEmployee(int id);

    void listEmployees();
}
