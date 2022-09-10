package com.exalt.bankaccount.infrastracture.repository;

import com.exalt.bankaccount.domain.Account;
import com.exalt.bankaccount.domain.repository.AccountRepository;
import com.exalt.bankaccount.infrastracture.repository.mongo.SpringDataMongoAccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
@SpringBootTest
@TestPropertySource("classpath:bankaccount-test.properties")
@Disabled
class MongoDbAccountRepositoryLiveTest {

    @Autowired
    private SpringDataMongoAccountRepository mongoAccountRepository;

    @Autowired
    private AccountRepository accountRepository;

    @AfterEach
    void cleanUp() {
        mongoAccountRepository.deleteAll();
    }

    @Test
    void shouldFindById_thenReturnAccount() {
        // given
        final UUID id = UUID.randomUUID();
        final Account account = createAccount(id);
        // when
        accountRepository.save(account);
        final Optional<Account> result = accountRepository.load(id);
        //Then
        assertEquals(account, result.get());
    }

    private Account createAccount(UUID id) {
        return new Account(id, BigDecimal.valueOf(2000));
    }
}