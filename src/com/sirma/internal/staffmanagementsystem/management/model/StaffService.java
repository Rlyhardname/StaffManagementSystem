package com.sirma.internal.staffmanagementsystem.management.model;

import com.sirma.internal.staffmanagementsystem.management.enums.Department;
import com.sirma.internal.staffmanagementsystem.management.interfaces.CustomReader;
import com.sirma.internal.staffmanagementsystem.management.interfaces.CustomWriter;
import com.sirma.internal.staffmanagementsystem.management.interfaces.Service;

public class StaffService implements Service {
    private final CustomReader reader;
    private final CustomWriter writer;
    private final String URI;


    public StaffService(CustomReader reader, CustomWriter writer, String URI) {
        this.reader = reader;
        this.writer = writer;
        this.URI = URI;
    }

    public CustomReader getReader() {
        return reader;
    }

    public CustomWriter getWriter() {
        return writer;
    }

    public String getURI() {
        return URI;
    }

    @Override
    public Employee search(int id) {
        return null;
    }

    @Override
    public Employee search(String name) {
        return null;
    }

    @Override
    public Employee search(Department department) {
        return null;
    }


}
