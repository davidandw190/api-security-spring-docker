package com.davidandw190.apisecurity.service;

import com.davidandw190.apisecurity.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    // Save a student
    Student addStudent(Student student);

    List<Student> getAllStudents();

    // Get specific student
    Optional<Student> findById(Integer id);

    // Update student
    Student updateStudent(Student student);

    // Delete student
    Boolean deleteStudent(Integer id);

}
