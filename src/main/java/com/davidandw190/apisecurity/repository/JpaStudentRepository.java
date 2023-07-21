package com.davidandw190.apisecurity.repository;

import com.davidandw190.apisecurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStudentRepository extends JpaRepository<Student, Integer> {


}
