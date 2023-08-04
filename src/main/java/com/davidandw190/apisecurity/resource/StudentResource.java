package com.davidandw190.apisecurity.resource;

import com.davidandw190.apisecurity.model.Student;
import com.davidandw190.apisecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Controller for managing student resources.
 */

@RestController
@RequestMapping(path = "/api/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(@Qualifier(value = "SQLService") StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Get all students.
     *
     * @return List of students.
     */
    @GetMapping()
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    /**
     * Get a student by ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The student with the given ID, if found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    /**
     * Add a new student.
     *
     * @param student The student object to add.
     * @return The created student with its generated ID.
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        // student.setId(studentService.getAllStudents().size() + 1); // only for in memory
        return ResponseEntity.created(getLocation(student.getId())).body(studentService.addStudent(student));
    }

    /**
     * Update an existing student.
     *
     * @param student The updated student object.
     * @return The updated student.
     */
    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    /**
     * Delete a student by ID.
     *
     * @param id The ID of the student to delete.
     * @return True if the student was successfully deleted, false otherwise.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    private URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
