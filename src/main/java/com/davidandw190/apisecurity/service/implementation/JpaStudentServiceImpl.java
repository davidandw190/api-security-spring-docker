package com.davidandw190.apisecurity.service.implementation;

import com.davidandw190.apisecurity.model.Student;
import com.davidandw190.apisecurity.repository.JpaStudentRepository;
import com.davidandw190.apisecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier(value = "SQLService")
public class JpaStudentServiceImpl implements StudentService {

    private final JpaStudentRepository studentRepository;

    @Autowired
    public JpaStudentServiceImpl(JpaStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Student student) {
         Student toBeUpdated = studentRepository.findById(student.getId())
                 .orElseThrow( () -> new RuntimeException("No user found with ID: " + student.getId()) );

         toBeUpdated.setId(student.getId());
         toBeUpdated.setFirstName(student.getFirstName());
         toBeUpdated.setLastName(student.getLastName());
         toBeUpdated.setEmail(student.getEmail());

         return studentRepository.save(toBeUpdated);
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        return null;
    }
}
