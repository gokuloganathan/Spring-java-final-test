package com.employee.EmployeeDetailsManager.dto;

import com.employee.EmployeeDetailsManager.modal.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeResponseDto {
    private int employeeid;
    private String firstname;
    private String lastname;
    private String department;
    private String designation;
    private Double salary;

    public EmployeeResponseDto(Employee employee){

    }
}
