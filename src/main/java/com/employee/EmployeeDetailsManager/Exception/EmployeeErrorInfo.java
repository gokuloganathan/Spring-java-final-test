package com.employee.EmployeeDetailsManager.Exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EmployeeErrorInfo {
private int statusCode;
private String message;
private LocalDateTime timestamp;
}
