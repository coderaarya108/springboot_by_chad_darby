package com.example.springboot.employee_rest_app.controller;

import com.example.springboot.employee_rest_app.dao.EmployeeDAO;
import com.example.springboot.employee_rest_app.entity.Employee;
import com.example.springboot.employee_rest_app.exception.EmployeeNotFoundException;
import com.example.springboot.employee_rest_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.security.spec.ECPoint;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;
    private JsonMapper  jsonMapper ;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService , JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    // expose "/employee" endpoint
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // endpoint to get employee by id "/employee/{employeeId}"
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.getEmployeeById(employeeId);
        if( theEmployee == null ) {
            throw new EmployeeNotFoundException("Employee id : " +  employeeId + " not found .");
        }
        return theEmployee;
    }

    // Add an employee
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {

        // just in case the the REST client sends id in request body, we will set it 0 so it will
        // be considered as new insert by spring
        employee.setId(0);
        return employeeService.save(employee);
    }

    // Update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody  Employee employee) {
        int empId = employee.getId();
        if( employeeService.getEmployeeById(empId) == null ) {
            throw new EmployeeNotFoundException("Employee id : " +  empId + " not found .");
        }
        return employeeService.save(employee);
    }

    // To only update given fields rather than the complete object
    @PatchMapping("/employees/{employeeId}")
    public void  patchEmployee(@PathVariable int employeeId, @RequestBody Map<String , Object> patchPayload) {
        Employee theEmployee = employeeService.getEmployeeById(employeeId);
        if(  theEmployee == null ) {
            throw new EmployeeNotFoundException("Employee id : " +  employeeId + " not found .");
        }

        // throw exception if patch payload contains id field as we don't want to update id field
        if( patchPayload.containsKey("id") ) {
            throw new EmployeeNotFoundException("Employee id field cannot be updated .");
        }

        Employee patchedEmployee = jsonMapper.updateValue(theEmployee , patchPayload);
        employeeService.save(patchedEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void  deleteEmployee(@PathVariable int employeeId) {
        if( employeeService.getEmployeeById(employeeId) == null ) {
            throw new EmployeeNotFoundException("Employee id : " +  employeeId + " not found .");
        }
         employeeService.deleteById(employeeId);
    }


}
