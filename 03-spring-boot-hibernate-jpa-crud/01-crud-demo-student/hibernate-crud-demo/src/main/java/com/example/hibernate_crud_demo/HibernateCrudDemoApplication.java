package com.example.hibernate_crud_demo;

import com.example.hibernate_crud_demo.dao.StudentDAO;
import com.example.hibernate_crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateCrudDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernateCrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			System.out.println("Hello, Hibernate CRUD Demo!");

			 createStudent(studentDAO);
			//findById(studentDAO, 3) ;

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO , 3);

			// updateMultipleStudentsByLastname(studentDAO);

			// deleteStudentById(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + rowsDeleted + " students");
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.deleteById(studentId);
	}

	private void updateMultipleStudentsByLastname(StudentDAO studentDAO) {
		studentDAO.updateMultipleStudentsByLastName("Kaur" , "Sharma");
	}

	private void updateStudent(StudentDAO studentDAO, int id) {
		Student student = studentDAO.findById(id);
		System.out.println("Updating student...");
		student.setFirstName("Doooby");
		studentDAO.update(student);

		System.out.println("Updated student: " + studentDAO.findById(id));
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student student1 = new Student("Mad", "Gu", "mad@mail.com");
		Student student2 = new Student("Simran", "Kaur", "simran@mail.com");
		Student student3 = new Student("siyara", "bad", "siya@mail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		//display the id of the saved student object
		System.out.println("Saved student. Generated id: " + student1.getId() + " and " + student2.getId() + " and " + student3.getId());

	}

	private void findById(StudentDAO studentDAO , int id) {
		System.out.println("Finding student with id: " + id);
		Student student=  studentDAO.findById(id);
		System.out.println(student);

	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("Finding all students...");
		studentDAO.findAll().forEach(System.out::println);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Finding students with last name: Holland");
		studentDAO.findByLastName("Holland").forEach(System.out::println);
	}

}
