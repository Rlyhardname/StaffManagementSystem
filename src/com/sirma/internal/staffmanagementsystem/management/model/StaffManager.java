package com.sirma.internal.staffmanagementsystem.management.model;

import com.sirma.internal.staffmanagementsystem.management.enums.Department;
import com.sirma.internal.staffmanagementsystem.management.exceptions.CorruptedDataException;
import com.sirma.internal.staffmanagementsystem.management.interfaces.Manager;
import com.sirma.internal.staffmanagementsystem.management.interfaces.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StaffManager implements Manager {
    private Service service;

    private List<Employee> employees;

    public StaffManager(Service service) {
        this.service = service;
        initializeCSV();
    }

    private List<Employee> initializeCSV() {
        employees = ((StaffService) service).getReader().read(((StaffService) service).getURI());
        return employees;
    }


    public Service getService() {
        return service;
    }


    private boolean isSaved() {
        System.out.println(employees.toString());
        ((StaffService) service).getWriter().write(((StaffService) service).getURI(), employees);
        return true;
    }

    public void exitApp() {
        if (!isSaved()) {
            throw new CorruptedDataException("CSV file error...Data didn't get save!");
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void editEmployee(int id, Scanner sc) {
        for (Employee item : employees) {
            if (item.getId() == id) {
                System.out.println("Write 'd' for department, 'r' for role, 's' for salary");
                switch (sc.nextLine().charAt(0)) {
                    case 'd':
                        System.out.println("Departments are as follows:%nFinance(f)%n" +
                                "Strategic_business(s), IT(i), Logistics(l), Customer_Support(c)");
                        String tempDep = String.valueOf(sc.nextLine().charAt(0));
                        Department dep = Department.valueOf(tempDep);
                        item.setDepartment(dep);
                        break;
                    case 'r':
                        System.out.println("Write a new role..");
                        String role = String.valueOf(sc.nextLine().charAt(0));
                        item.setRole(role);
                        break;
                    case 's':
                        System.out.println("Write the new salary...");
                        Double salary = Double.parseDouble(sc.nextLine());
                        item.setSalary(salary);
                        break;
                }

            }

        }

    }

    @Override
    public void fireEmployee(int id) {
        Iterator<Employee> iter = employees.iterator();
        while (iter.hasNext()) {
            Employee emp = iter.next();
            if (emp.getId() == id) {
                iter.remove();
                break;
            }
        }
    }

    @Override
    public void listEmployees() {
        for (Employee item : employees) {
            System.out.println(item);
        }
    }

    public void add(Employee employee) {
        boolean exists = false;
        for (Employee item : employees) {
            if (item.getId() == employee.getId()) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            employees.add(employee);
        } else {
            System.out.println("Employee with id " + employee.getId() + " already exists in our DB");
        }
    }
}
