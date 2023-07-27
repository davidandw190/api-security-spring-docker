package com.davidandw190.apisecurity.repository;

import org.apache.catalina.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaStudentRepository<Role, Long>  {

}
