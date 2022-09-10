package com.exalt.bankaccount.domain.service;

import com.exalt.bankaccount.domain.Account;
import com.exalt.bankaccount.domain.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.UUID;


public class DomainAccountService implements AccountService {

    private final AccountRepository accountRepository;

    public DomainAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void depositOrCreateNew(UUID id, BigDecimal amount) {
        var account = accountRepository.load(id)
                .orElse(new Account(id, amount));

        account.deposit(amount);

        accountRepository.save(account);
    }

    @Override
    public boolean withdraw(UUID id, BigDecimal amount) {
        var account = accountRepository.load(id)
                .orElseThrow(NoSuchElementException::new);

        boolean hasWithdrawn = account.withdraw(amount);

        if (hasWithdrawn) {
            accountRepository.save(account);
        }
        return hasWithdrawn;
    }
}
