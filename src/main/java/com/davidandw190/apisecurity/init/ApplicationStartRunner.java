package com.davidandw190.apisecurity.init;

import com.davidandw190.apisecurity.enums.UserRole;
import com.davidandw190.apisecurity.model.Role;
import com.davidandw190.apisecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ApplicationStartRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public ApplicationStartRunner(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(UserRole.ROLE_USER);
        Role roleAdmin = new Role(UserRole.ROLE_ADMIN);

        roleRepository.saveAll(Arrays.asList(roleUser, roleAdmin));
    }
}
