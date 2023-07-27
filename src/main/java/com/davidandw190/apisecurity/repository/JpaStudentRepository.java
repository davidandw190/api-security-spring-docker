package com.davidandw190.apisecurity.repository;

import com.davidandw190.apisecurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Principal;

@Repository
public interface JpaStudentRepository<R extends Principal, L extends Number> extends JpaRepository<Student, Integer> {


}
