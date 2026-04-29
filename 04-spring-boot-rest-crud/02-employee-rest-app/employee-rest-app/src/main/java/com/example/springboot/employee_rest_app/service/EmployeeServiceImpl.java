package com.example.springboot.employee_rest_app.service;

import com.example.springboot.employee_rest_app.dao.EmployeeDAO;
import com.example.springboot.employee_rest_app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // define employeedao field
    private final EmployeeDAO  employeeDao;

    //use constructor injection to inject employee dao
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {

        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
         employeeDao.deleteById(id);
    }
}
