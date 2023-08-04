package com.davidandw190.apisecurity.resource;

import com.davidandw190.apisecurity.model.Account;
import com.davidandw190.apisecurity.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController("/api/accounts")
public class AccountResource {

    private final AccountService accountService;

    @Autowired
    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    public URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }



}
