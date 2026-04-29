package com.example.springboot.employee_rest_app.dao;

import com.example.springboot.employee_rest_app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {

        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {

        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(Integer id) {

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
