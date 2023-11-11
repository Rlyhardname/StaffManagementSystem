package com.sirma.internal.staffmanagementsystem;

public interface Service {

    Employee search(int id);

    Employee search(String name);

    Employee search(Department department);

}
