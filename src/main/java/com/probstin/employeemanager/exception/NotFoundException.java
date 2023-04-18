package com.probstin.employeemanager.exception;

public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "NotFoundException: " + getMessage();
    }
    
}
