package com.sirma.internal.staffmanagementsystem;

import java.util.List;

public interface Manager {

    void exitApp();

    void addEmployee(Employee employee);

    void editEmployee(int id);
    void fireEmployee(int id);
    void listEmployees();
}
