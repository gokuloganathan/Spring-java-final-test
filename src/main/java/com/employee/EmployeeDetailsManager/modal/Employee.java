package com.employee.EmployeeDetailsManager.modal;


import com.employee.EmployeeDetailsManager.dto.EmployeeRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name="Emp_TB")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;

    @Column(name = "FNAME")
    @NotBlank(message = "first name can't be empty")
    @Pattern(regexp = "[A-Za-z]+")
    private String firstname;

    @Column(name = "LNAME")
    @NotBlank(message = "last name can't be empty")
    @Pattern(regexp = "[A-Za-z]+")
    private String lastname;


    @Column(name = "DEPT")
    @NotBlank(message = "department can't be empty")
    private String department;

    @Column(name = "DESG")
    @NotBlank(message = "designation can't be empty")
    private String designation;

    @Column(name = "SALARY")
    @Min(20001)
    private Double salary;

    public Employee(EmployeeRequestDto employeeRequestDto){
        this.setFirstname(employeeRequestDto.getFirstname());
        this.setLastname(employeeRequestDto.getLastname());
        this.setDepartment(employeeRequestDto.getDepartment());
        this.setDesignation(employeeRequestDto.getDesignation());
        this.setSalary(employeeRequestDto.getSalary());
    }
}
