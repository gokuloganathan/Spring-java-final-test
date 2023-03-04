package com.employee.EmployeeDetailsManager.repository;

import com.employee.EmployeeDetailsManager.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
