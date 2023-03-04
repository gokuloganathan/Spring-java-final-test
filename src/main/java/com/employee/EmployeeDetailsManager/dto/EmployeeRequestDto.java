package com.employee.EmployeeDetailsManager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeRequestDto {
    private String firstname;
    private String lastname;
    private String department;
    private String designation;
    private Double salary;
}
