package com.launchcode.classmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer gradeLevel;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, Integer gradeLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gradeLevel = gradeLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}