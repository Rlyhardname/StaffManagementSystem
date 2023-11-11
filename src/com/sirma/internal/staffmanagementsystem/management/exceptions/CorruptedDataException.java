package com.sirma.internal.staffmanagementsystem.management.exceptions;

public class CorruptedDataException extends RuntimeException {
    public CorruptedDataException(String error){
        super(error);
    }
}
