package com.example.springboot.employee_rest_app.dao;

import com.example.springboot.employee_rest_app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it  , no need to write any code
}
