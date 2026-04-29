package com.example.springboot.employee_rest_app.dao;

import com.example.springboot.employee_rest_app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee save(Employee employee);

    void  deleteById(Integer id);
}
