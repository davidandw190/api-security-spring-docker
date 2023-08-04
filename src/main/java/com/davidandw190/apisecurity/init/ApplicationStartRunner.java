package com.davidandw190.apisecurity.init;

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
        Role roleUser = new Role(1L, "123689", "ROLE_USER");
        Role roleAdmin = new Role(2L, "456542", "ROLE_ADMIN");

        roleRepository.saveAll(Arrays.asList(roleUser, roleAdmin));
    }
}
