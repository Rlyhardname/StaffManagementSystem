package com.sirma.internal.staffmanagementsystem.management.enums;

public enum Department {
    FINANCE("f"),IT("i"),STRATEGIC_BUSINESS("s"),LOGISTICS("l"),CUSTOMER_SUPPORT("c");

    String depValue;
    Department(String depValue) {
        this.depValue = depValue;
    }
}
