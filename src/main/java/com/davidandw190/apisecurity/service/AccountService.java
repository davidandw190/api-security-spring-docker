package com.davidandw190.apisecurity.service;

import com.davidandw190.apisecurity.model.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account findByUsername(String username);

    List<Account> getAllAccounts();
}
