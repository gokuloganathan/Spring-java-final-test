package com.employee.EmployeeDetailsManager.controller;
import com.employee.EmployeeDetailsManager.dto.EmployeeRequestDto;
import com.employee.EmployeeDetailsManager.dto.EmployeeResponseDto;
import com.employee.EmployeeDetailsManager.service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeAPI {
    @Autowired
    private EmployeeService employeeService;

    public static final Log LOGGER = LogFactory.getLog(EmployeeAPI.class);

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees(){
        List<EmployeeResponseDto> em = employeeService.getAllEmployees();
        if(em.size() > 0){
            //LOGGER.info(em.size());
            return new ResponseEntity<List<EmployeeResponseDto>>(em, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<EmployeeResponseDto>>(em,HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping
    public ResponseEntity<EmployeeResponseDto> addNewEmployee(@RequestBody EmployeeRequestDto employeeRequestDTO){
        return new ResponseEntity<EmployeeResponseDto>(employeeService.addNewEmployee(employeeRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }


    @PutMapping("/{id}")
    public EmployeeResponseDto updateEmployeeById(@RequestBody EmployeeRequestDto employeeRequestDTO,@PathVariable int id){
        return employeeService.updateEmployeeById(employeeRequestDTO,id);
    }

    @DeleteMapping("{id}")
    public EmployeeResponseDto deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }
}

