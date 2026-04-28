package com.example.hibernate_crud_demo.dao;

import com.example.hibernate_crud_demo.entity.Student;

import java.util.List;

public interface StudentDAO {
        void save(Student student);
        Student findById(int id);
        List<Student> findAll();
        void update(Student student);
        void deleteById(int id);
        List<Student> findByLastName(String lastName);

        Integer updateMultipleStudentsByLastName(String lastName, String newLastName);

        int deleteAll();
}
