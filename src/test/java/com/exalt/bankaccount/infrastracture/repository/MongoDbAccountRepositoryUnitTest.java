package com.exalt.bankaccount.infrastracture.repository;

import com.exalt.bankaccount.domain.Account;
import com.exalt.bankaccount.infrastracture.repository.mongo.MongoDbAccountRepository;
import com.exalt.bankaccount.infrastracture.repository.mongo.SpringDataMongoAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MongoDbAccountRepositoryUnitTest {

    private SpringDataMongoAccountRepository springDataMongoAccountRepository;
    private MongoDbAccountRepository tested;

    @BeforeEach
    void setUp() {
        springDataMongoAccountRepository = mock(SpringDataMongoAccountRepository.class);

        tested = new MongoDbAccountRepository(springDataMongoAccountRepository);
    }

    @Test
    void shouldFindById_thenReturnAccount() {
        final UUID id = UUID.randomUUID();
        final Account account = createAccount(id);
        when(springDataMongoAccountRepository.findById(id)).thenReturn(Optional.of(account));

        final Optional<Account> result = tested.load(id);

        assertEquals(account, result.get());
    }

    @Test
    void shouldSaveAccount_viaSpringDataAccountRepository() {
        final UUID id = UUID.randomUUID();
        final Account account = createAccount(id);

        tested.save(account);

        verify(springDataMongoAccountRepository).save(account);
    }

    private Account createAccount(UUID id) {
        return new Account(id, BigDecimal.valueOf(1234));
    }
}