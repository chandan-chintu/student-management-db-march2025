package com.jpahibernate.example.student_management_db.service;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service // it contains business logics of the application
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student studentRequest){
        studentRepository.save(studentRequest);
        return "Student saved into db successfully";
    }

    public Student getStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return  null;
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String countStudents(){
        long totalCount = studentRepository.count();
        return "Total number of students present are : "+totalCount;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    public String updateStudentByPut(int id,Student newStudentRequest){
        // find student with id
        // if the student is present update it
        // else no need to update

       Student alreadyExistingStudent = getStudentById(id);
       if(alreadyExistingStudent!=null){
           // perform update
           studentRepository.save(newStudentRequest);
           return "Student updated successfully";
       } else{
           return "Update cannot be performed as Student with id :"+id+" is not present";
       }
    }

    public String updateStudentByPatch(int id,String mobile) {
        // find student with id
        // if the student is present update it
        // else no need to update

        Student alreadyExistingStudent = getStudentById(id);
        if (alreadyExistingStudent != null) {
            // perform update
            alreadyExistingStudent.setMobile(mobile);
            studentRepository.save(alreadyExistingStudent);
            return "Student updated successfully";
        } else {
            return "Update cannot be performed as Student with id :" + id + " is not present";
        }
    }

}
