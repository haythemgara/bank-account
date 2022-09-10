package com.exalt.bankaccount.infrastracture.repository.mongo;

import com.exalt.bankaccount.domain.Account;
import com.exalt.bankaccount.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class MongoDbAccountRepository implements AccountRepository {

    private final SpringDataMongoAccountRepository accountRepository;

    @Autowired
    public MongoDbAccountRepository(final SpringDataMongoAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> load(UUID id) {
        return accountRepository.findById(id);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
