package com.sirma.internal.staffmanagementsystem.management.model;

import com.sirma.internal.staffmanagementsystem.management.enums.Department;
import com.sirma.internal.staffmanagementsystem.management.exceptions.CorruptedDataException;
import com.sirma.internal.staffmanagementsystem.management.interfaces.Manager;
import com.sirma.internal.staffmanagementsystem.management.interfaces.Service;
import com.sirma.internal.staffmanagementsystem.management.util.EmpUtil;

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
    public void editEmployee(long id, Scanner sc) {
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
    public void fireEmployee(long id) {
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

    @Override
    public void execute(String command, Scanner sc) {
        switch (command.toLowerCase()) {
            case "add":
                System.out.println("Input id, name, startDate(yyyy/mm/dd), endDate(yyyy/mm/dd), department, " +
                        "Departments are as follows:%nFinance(f)%n\" +\n" +
                        "                                \"Strategic_business(s), IT(i), Logistics(l), Customer_Support(c)\", role, salary");
                String[] data = sc.nextLine().split(",");
                Employee addEmployee = EmpUtil.parseEntry(data);
                add(addEmployee);
                break;
            case "list":
                listEmployees();
                break;
            case "fire":
                long id = Long.parseLong(sc.nextLine());
                fireEmployee(id);
                break;
            case "edit":
                long id1 = Long.parseLong(sc.nextLine());
                editEmployee((id1), sc);
                break;
            case "searchid":
                long id2 = Long.parseLong(sc.nextLine());
                System.out.println(service.search(id2));
                break;
            case "searchname":
                String name = sc.nextLine();
                System.out.println(service.search(name));
                break;
            case "searchdep":
                Department dep = Department.valueOf(sc.nextLine());
                System.out.println(service.search(dep));
                break;

        }
    }

    public void add(Employee employee) {
        for (Employee item : employees) {
            if (item.getId() == employee.getId()) {
                throw new IllegalArgumentException("Employee with such id exists");
            }
        }
        employees.add(employee);
    }
}
