package com.exalt.bankaccount.domain.repository;

import com.exalt.bankaccount.domain.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Optional<Account> load(UUID id);

    void save(Account account);
}
