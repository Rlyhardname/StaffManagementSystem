package com.sirma.internal.staffmanagementsystem;

public class CorruptedDataException extends RuntimeException {
    CorruptedDataException(String error){
        super(error);
    }
}
