package com.employee.EmployeeDetailsManager.Exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int id){
        super("No employee found with id "+id);
    }
}
