package com.davidandw190.apisecurity.repository;

import com.davidandw190.apisecurity.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryStudentRepository {
    private static final List<Student> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Student(1, "John", "Doe", "john.doe@gmail.com"));
        DATABASE.add(new Student(2, "Natalie", "Smith", "nati.smith@gmail.com"));
        DATABASE.add(new Student(3, "David", "Black", "dave.black@gmail.com"));
        DATABASE.add(new Student(4, "Sam", "Miller", "s.miller@gmail.com"));
    }

    void addStudent(Student student) {
        DATABASE.add(student);
    }

    Student findById(Integer id) {
        return DATABASE
                .stream()
                .filter(map -> id.equals(map.getId()))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("No student found with ID: " + id )
                );
    }

    // Update student
    void updateStudent(Student student) {
        DATABASE.set(DATABASE.indexOf(student), student);
    }

    // Delete student
    Boolean deleteStudent(Integer id) {
        Student toBeDeleted
                = DATABASE
                .stream()
                .filter(map -> id.equals(map.getId()))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("No student found with ID: " + id )
                );
        DATABASE.remove(toBeDeleted);

        return Boolean.TRUE;
    }


}
