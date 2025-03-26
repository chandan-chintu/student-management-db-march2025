package com.jpahibernate.example.student_management_db.controller;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    // controller <-> service <-> repository

    @Autowired
    public StudentService studentService; // StudentService studentService = new StudentService();

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student studentRequest){
        String response = studentService.addStudent(studentRequest);
        return response;
    }
    
    @GetMapping("/find/{id}")
    public Student getStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents(){
        List<Student> studentList = studentService.getAllStudent();
        return studentList;
    }

    @GetMapping("/count")
    public String getCountOfStudents(){
        String response = studentService.countStudents();
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteStudentById(id);
        return response;
    }

    @PutMapping("/updatePut/{id}") // updates the whole object any number fields
    public String updateStudent(@PathVariable int id, @RequestBody Student newStudentRequest){
        String response = studentService.updateStudentByPut(id, newStudentRequest);
        return response;
    }

    //  @RequestParam  - it takes the input in the form of request parameter query
    @PatchMapping("/updatePatch/{id}") // updates the specific fields
    public String updateStudentMobile(@PathVariable int id, @RequestParam String mobile, @RequestParam String email){
        String response = studentService.updateStudentByPatch(id,mobile);
        return response;
    }

}
