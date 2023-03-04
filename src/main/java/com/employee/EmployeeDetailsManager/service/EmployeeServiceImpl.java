package com.employee.EmployeeDetailsManager.service;

import com.employee.EmployeeDetailsManager.Exception.EmployeeNotFoundException;
import com.employee.EmployeeDetailsManager.dto.EmployeeRequestDto;
import com.employee.EmployeeDetailsManager.dto.EmployeeResponseDto;
import com.employee.EmployeeDetailsManager.modal.Employee;
import com.employee.EmployeeDetailsManager.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        List<EmployeeResponseDto> employeeResponseDTOList = new ArrayList<EmployeeResponseDto>();
        List<Employee> employeeList = employeeRepo.findAll();
        employeeResponseDTOList  =  employeeList.stream().map((employee)-> {
            EmployeeResponseDto employeeResponseDTO = new EmployeeResponseDto(employee);
            return employeeResponseDTO;
        }).collect(Collectors.toList());
        return employeeResponseDTOList;
    }

        @Override
        public EmployeeResponseDto getEmployeeById(int id){
            Optional<Employee> employeeOptional= employeeRepo.findById(id);
            if(employeeOptional.isPresent()){
                Employee employee=employeeOptional.get();
                EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto(employee);
                return employeeResponseDto;
            }
            else{
                throw new EmployeeNotFoundException(id);
            }

        }

        @Override
        public EmployeeResponseDto addNewEmployee(EmployeeRequestDto employeeRequestDto) {
            Employee employee = new Employee(employeeRequestDto);
            Employee newEmployee = employeeRepo.save(employee);
            EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto(newEmployee);
            return employeeResponseDto;
        }

        @Override
        public EmployeeResponseDto updateEmployeeById(EmployeeRequestDto employeeRequestDto,int id) {
            Optional<Employee> employeeOptional= employeeRepo.findById(id);
            if(employeeOptional.isPresent()){
                Employee optionalEmployee = employeeOptional.get();
                optionalEmployee.setFirstname(employeeRequestDto.getFirstname());
                optionalEmployee.setLastname(employeeRequestDto.getLastname());
                optionalEmployee.setDesignation(employeeRequestDto.getDesignation());
                optionalEmployee.setDepartment(employeeRequestDto.getDepartment());
                optionalEmployee.setSalary(employeeRequestDto.getSalary());
                employeeRepo.flush();
                EmployeeResponseDto employeeResponseDTO = new EmployeeResponseDto(optionalEmployee);
                return employeeResponseDTO;
            }
            else{
                throw new EmployeeNotFoundException(id);
            }
        }

        @Override
        public EmployeeResponseDto deleteEmployeeById(int id) {
            Optional<Employee> optionalEmployee = employeeRepo.findById(id);
            if(optionalEmployee.isPresent()){
                Employee DeletedEmployee = optionalEmployee.get();
                employeeRepo.delete(DeletedEmployee);
                EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto(DeletedEmployee);
                return employeeResponseDto;
            }
            else{
                throw new EmployeeNotFoundException(id);
            }
        }
}

