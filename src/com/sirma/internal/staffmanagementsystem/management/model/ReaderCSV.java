package com.sirma.internal.staffmanagementsystem.management.model;

import com.sirma.internal.staffmanagementsystem.management.interfaces.CustomReader;
import com.sirma.internal.staffmanagementsystem.management.util.EmpUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
                Employee employee = EmpUtil.parseEntry(fields);
                if (employee != null) {
                    employees.add(employee);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return employees;
    }


}
