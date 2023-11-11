package com.sirma.internal.staffmanagementsystem;

import java.util.List;
import java.util.Scanner;

public interface Manager {

    void exitApp();

    void addEmployee(Employee employee);

    void editEmployee(int id, Scanner sc);

    void fireEmployee(int id);

    void listEmployees();
}
