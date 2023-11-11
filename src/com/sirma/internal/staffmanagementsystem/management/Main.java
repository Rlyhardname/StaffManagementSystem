package com.sirma.internal.staffmanagementsystem.management;

import com.sirma.internal.staffmanagementsystem.management.interfaces.CustomReader;
import com.sirma.internal.staffmanagementsystem.management.interfaces.CustomWriter;
import com.sirma.internal.staffmanagementsystem.management.interfaces.Manager;
import com.sirma.internal.staffmanagementsystem.management.interfaces.Service;
import com.sirma.internal.staffmanagementsystem.management.model.ReaderCSV;
import com.sirma.internal.staffmanagementsystem.management.model.StaffManager;
import com.sirma.internal.staffmanagementsystem.management.model.StaffService;
import com.sirma.internal.staffmanagementsystem.management.model.WriterCSV;

import java.util.Scanner;

// https://github.com/Rlyhardname
public class Main {

    public static void main(String[] args) {
        CustomReader reader = new ReaderCSV();
        CustomWriter writer = new WriterCSV();
        String uri = "D:\\mock.csv";
        Service service = new StaffService(reader, writer, uri);
        Manager manager = new StaffManager(service);
        System.out.println("Welcome to Staff Management System");
        displayCommands();
        String testCaseAdd = "22,ivan,2000/11/01,2005/10/25,i,bricklayer,1337.77";
        boolean isRunning = true;
        try (Scanner sc = new Scanner(System.in)) {
            while (isRunning) {
                String command = sc.nextLine();
                if (command.equals("exit")) {
                    sc.close();
                    break;
                }
                manager.execute(command, sc);
                displayCommands();
            }
        }

//        Add Employee
//        1, Peter Peterson, IT, Junior Java Developer, 1400.50
//        Add Employee
//        2, Ivan Ivanson, IT, Junior Front - End Developer, 1400.00
//        Edit 1
//        1, Peter Peterson, IT, Java Developer, 2500.00
//        List employees
//        Search Department Marketing
//        Search Id 1
//        Fire 1
//        Search Name Peter
//        Save & amp;
//        Exit


    }

    private static void displayCommands() {
        System.out.printf(" Type:%n'Add' for AddEmployee%n'fire' for FireEmployee%n'edit' for editEmployee%n" +
                "'list' for listAllEmployees%n'searchId' for searchById%n'searchName' for searchByName%n" +
                "'searchDep' for searchByDepartment%n");
    }
}