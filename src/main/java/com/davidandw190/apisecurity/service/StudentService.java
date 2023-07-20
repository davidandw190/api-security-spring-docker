package com.davidandw190.apisecurity.service;

import com.davidandw190.apisecurity.model.Student;

import java.util.List;

public interface StudentService {

    // Save a student
    void addStudent(Student student);

    // Get students
    List<Student> getAllStudents();

    // Get specific student
    Student findById(Long id);

    // Update student
    void updateStudent(Student student);

    // Delete student
    void deleteStudent(Long id);

}
