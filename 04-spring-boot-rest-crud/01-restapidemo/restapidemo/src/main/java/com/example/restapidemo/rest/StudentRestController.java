package com.example.restapidemo.rest;

import com.example.restapidemo.entity.Student;
import com.example.restapidemo.exception.StudentErrorResponse;
import com.example.restapidemo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students ;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("Premua", "Yadav"));
        students.add(new Student("Artiya", "Yaduvanshi"));
        students.add(new Student("Ruda", "Singh"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    // define endpoint for "/students/{studentId}" - retrieve student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list ... keep it simple for now
        // later we'll cover error handling

        if( studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id : " + studentId + " not found");
        }
        return students.get(studentId);
    }
}
