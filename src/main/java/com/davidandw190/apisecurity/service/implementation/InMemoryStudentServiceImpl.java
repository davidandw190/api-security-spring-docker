package com.davidandw190.apisecurity.service.implementation;

import com.davidandw190.apisecurity.model.Student;
import com.davidandw190.apisecurity.repository.InMemoryStudentRepository;
import com.davidandw190.apisecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InMemoryStudentServiceImpl implements StudentService {

    private final InMemoryStudentRepository studentRepository;

    @Autowired
    public InMemoryStudentServiceImpl(InMemoryStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
        this.studentRepository.addStudent(student);

    }

    @Override
    public Student findById(Integer id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public void updateStudent(Student student) {
        this.studentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        this.studentRepository.deleteStudent(id);
    }
}
