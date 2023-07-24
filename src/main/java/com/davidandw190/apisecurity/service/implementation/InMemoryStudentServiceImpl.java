package com.davidandw190.apisecurity.service.implementation;

import com.davidandw190.apisecurity.model.Student;
import com.davidandw190.apisecurity.repository.InMemoryStudentRepository;
import com.davidandw190.apisecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier(value = "InMemoryService")
public class InMemoryStudentServiceImpl implements StudentService {

    private final InMemoryStudentRepository studentRepository;

    @Autowired
    public InMemoryStudentServiceImpl(InMemoryStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return this.studentRepository.addStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAllStudents();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return Optional.ofNullable(this.studentRepository.findById(id));
    }

    @Override
    public Student updateStudent(Student student) {
        return this.studentRepository.updateStudent(student);
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        return this.studentRepository.deleteStudent(id);
    }
}
