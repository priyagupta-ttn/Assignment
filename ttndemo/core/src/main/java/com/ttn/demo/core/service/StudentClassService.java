package com.ttn.demo.core.service;

import com.ttn.demo.core.beans.Student;

import java.util.List;

public interface StudentClassService {

    boolean addStudent(Student student);
    boolean deleteStudent(String id);
    boolean isStudentPassed(String id);
    Student getStudent(String id);
    List<Student> getAllStudents();
}
