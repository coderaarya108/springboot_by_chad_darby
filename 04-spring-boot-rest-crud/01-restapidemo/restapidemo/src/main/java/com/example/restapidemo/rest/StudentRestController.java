package com.example.restapidemo.rest;

import com.example.restapidemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
