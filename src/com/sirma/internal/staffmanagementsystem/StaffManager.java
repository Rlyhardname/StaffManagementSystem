package com.sirma.internal.staffmanagementsystem;

public class StaffManager implements Manager {
    private Service service;

    public StaffManager(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }
}
