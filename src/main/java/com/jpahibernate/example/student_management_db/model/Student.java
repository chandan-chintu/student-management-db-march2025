package com.jpahibernate.example.student_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // it is an entity or model class which directly represents the database tables/schema
@Table(name="student") // it creates table inside database
public class Student {

    @Id // it is the primary key of the table and cannot be duplicated
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false) // it creates a column inside mysql database table
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email",  nullable = false)//  nullable = false - it cannot be null
    private String email;

    @Column(name = "grade",  nullable = false)
    private String grade;

    @Column(name = "mobile",  nullable = false)
    private String mobile;

}
