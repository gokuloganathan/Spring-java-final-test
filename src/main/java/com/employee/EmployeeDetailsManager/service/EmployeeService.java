package com.employee.EmployeeDetailsManager.service;

import com.employee.EmployeeDetailsManager.dto.EmployeeRequestDto;
import com.employee.EmployeeDetailsManager.dto.EmployeeResponseDto;

import java.util.List;


public interface EmployeeService {
  List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto getEmployeeById(int id);

    EmployeeResponseDto addNewEmployee(EmployeeRequestDto employeeRequestDTO);

    EmployeeResponseDto updateEmployeeById(EmployeeRequestDto employeeRequestDTO,int id);

    EmployeeResponseDto deleteEmployeeById(int id);
}


