package com.davidandw190.apisecurity.service;

import com.davidandw190.apisecurity.model.Student;

import java.util.List;

public interface StudentService {

    // Save a student
    void addStudent(Student student);

    // Get specific student
    Student findById(Integer id);

    // Update student
    void updateStudent(Student student);

    // Delete student
    void deleteStudent(Integer id);

}
