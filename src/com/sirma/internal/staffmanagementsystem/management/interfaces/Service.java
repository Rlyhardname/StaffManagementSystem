package com.sirma.internal.staffmanagementsystem.management.interfaces;

import com.sirma.internal.staffmanagementsystem.management.model.Employee;
import com.sirma.internal.staffmanagementsystem.management.enums.Department;

public interface Service {

    Employee search(long id);

    Employee search(String name);

    Employee search(Department department);

}
