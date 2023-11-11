package com.sirma.internal.staffmanagementsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReaderCSV implements CustomReader {

    @Override
    public List<Employee> read(String uri) {
        BufferedReader bufferedReader = null;
        List<Employee> employees = new ArrayList<>();
        try {
            bufferedReader = Files.newBufferedReader(Path.of(uri));
            String line;
            while (Objects.nonNull(line = bufferedReader.readLine())) {
                String[] fields = line.split("\s*,\s*");
                Employee employee = parseEntry(fields);
                if (employee != null) {
                    employees.add(employee);
                }
                //   System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    private Employee parseEntry(String[] entry) {
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
