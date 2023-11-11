package com.sirma.internal.staffmanagementsystem.management.model;

import com.sirma.internal.staffmanagementsystem.management.interfaces.CustomWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterCSV implements CustomWriter {

    @Override
    public void write(String uri, List<Employee> employees) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = Files.newBufferedWriter(Path.of(uri));
            bufferedWriter.write(appendLine(employees));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private String appendLine(List<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees
        ) {
            sb.append(employee.getId() + ",");
            sb.append(employee.getName() + ",");
            sb.append(employee.getStartDate() + ",");
            sb.append(employee.getEndDate() + ",");
            sb.append(employee.getDepartment() + ",");
            sb.append(employee.getRole() + ",");
            sb.append(employee.getSalary());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
