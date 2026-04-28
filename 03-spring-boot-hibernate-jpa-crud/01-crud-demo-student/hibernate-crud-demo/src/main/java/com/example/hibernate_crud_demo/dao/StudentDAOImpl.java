package com.example.hibernate_crud_demo.dao;

import com.example.hibernate_crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private final EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
     public Student findById(int id) {
         return entityManager.find(Student.class, id);
     }

     @Override
     public List<Student> findAll() {
         TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
         return theQuery.getResultList();
     }

     @Override
     @Transactional
     public void update(Student student) {
         entityManager.merge(student);
       }

     @Override
     @Transactional
     public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
       }
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // Create the query
        TypedQuery<Student> lastNameQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //Set the query parameter
        lastNameQuery.setParameter("theData", lastName);

        //Return the results
         return lastNameQuery.getResultList();
    }

    @Transactional
    public Integer updateMultipleStudentsByLastName(String lastName, String newLastName) {
        return entityManager.createQuery("UPDATE Student set lastName=:newLastName where lastName=:theData")
                .setParameter("newLastName", newLastName)
                .setParameter("theData", lastName)
                .executeUpdate();

    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
