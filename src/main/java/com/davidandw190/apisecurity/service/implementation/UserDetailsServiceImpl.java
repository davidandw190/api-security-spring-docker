package com.davidandw190.apisecurity.service.implementation;

import com.davidandw190.apisecurity.model.Account;
import com.davidandw190.apisecurity.service.AccountService;
import com.davidandw190.apisecurity.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " was not found!");
        }

        if (account.getRoles() == null || account.getRoles().isEmpty()) {
            throw new RuntimeException("User has no roles");
        }

        Collection<GrantedAuthority> authorities = account.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getUserRole().name())) // Use the UserRole enum name
                .collect(Collectors.toList());

        return new User(
                account.getUsername(),
                account.getPassword(),
                account.isEnabled(),
                !account.isExpired(),
                !account.isCredentialsExpired(),
                !account.isLocked(),
                authorities);
    }
}
