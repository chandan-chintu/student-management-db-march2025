package com.jpahibernate.example.student_management_db;

import com.jpahibernate.example.student_management_db.controller.StudentController;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementDbApplication.class, args);

	}

}
