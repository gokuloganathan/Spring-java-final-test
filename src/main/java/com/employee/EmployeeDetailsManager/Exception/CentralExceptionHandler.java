package com.employee.EmployeeDetailsManager.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CentralExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeErrorInfo> handle_bus_not_found_Exception(EmployeeNotFoundException employeeNotFoundException){
        EmployeeErrorInfo employeeErrorInfo = new EmployeeErrorInfo();
        employeeErrorInfo.setStatusCode(HttpStatus.NOT_FOUND.value());
        employeeErrorInfo.setMessage("Employee not found in the db");
        employeeErrorInfo.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<EmployeeErrorInfo>(employeeErrorInfo,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<EmployeeErrorInfo> exceptionHandler(ConstraintViolationException exception) {
        EmployeeErrorInfo errorInfo = new EmployeeErrorInfo();
        errorInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorInfo.setTimestamp(LocalDateTime.now());

        String errorMsg = exception.getConstraintViolations().stream().map((cv)->cv.getMessage()).collect(Collectors.joining(","));
        errorInfo.setMessage(errorMsg);

        return new ResponseEntity<EmployeeErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
