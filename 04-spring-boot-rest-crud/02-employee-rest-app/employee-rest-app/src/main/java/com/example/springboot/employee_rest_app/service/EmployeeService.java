package com.example.springboot.employee_rest_app.service;

import com.example.springboot.employee_rest_app.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee save(Employee employee);

     void  deleteById(Integer id);
}