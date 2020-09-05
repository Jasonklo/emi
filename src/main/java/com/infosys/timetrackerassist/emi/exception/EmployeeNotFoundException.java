package com.infosys.timetrackerassist.emi.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int empId) {
        super("Could not find employee " + empId);
    }
}
