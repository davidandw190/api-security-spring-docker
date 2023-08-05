package com.davidandw190.apisecurity.service.implementation;

import com.davidandw190.apisecurity.model.Account;
import com.davidandw190.apisecurity.repository.AccountRepository;
import com.davidandw190.apisecurity.repository.RoleRepository;
import com.davidandw190.apisecurity.service.AccountService;
import com.davidandw190.apisecurity.model.Role;
import com.davidandw190.apisecurity.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public Account createAccount(Account newAccount) {
        newAccount.setPassword(encoder.encode(newAccount.getPassword()));
        Role role = roleRepository.findByName(UserRole.ROLE_USER);
        Set<Role> newAccountRoles = new HashSet<>();
        newAccountRoles.add(role);
        newAccount.setRoles(newAccountRoles);
        return accountRepository.save(newAccount);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
