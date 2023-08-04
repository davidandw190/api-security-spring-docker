package com.davidandw190.apisecurity.repository;

import com.davidandw190.apisecurity.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaStudentRepository<Role, Long>  {

    Role findByName(String roleUser);
}
