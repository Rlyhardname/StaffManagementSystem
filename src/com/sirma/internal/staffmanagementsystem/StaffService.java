package com.sirma.internal.staffmanagementsystem;

public class StaffService implements Service {
    private CustomReader reader;
    private CustomWriter writer;

    public StaffService(CustomReader reader, CustomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public CustomReader getReader() {
        return reader;
    }

    public CustomWriter getWriter() {
        return writer;
    }
}
