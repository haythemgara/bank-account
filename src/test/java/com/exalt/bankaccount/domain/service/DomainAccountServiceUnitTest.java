package com.exalt.bankaccount.domain.service;

import com.exalt.bankaccount.domain.Account;
import com.exalt.bankaccount.domain.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DomainAccountServiceUnitTest {

    private AccountRepository accountRepository;
    private DomainAccountService tested;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        tested = new DomainAccountService(accountRepository);
    }

    @Test
    void shouldCreateAccount_thenSaveIt() {
        //When
        tested.depositOrCreateNew(UUID.randomUUID(), BigDecimal.valueOf(2000));
        //Then
        verify(accountRepository).save(any(Account.class));
    }

    @Test
    void shouldWithdrawAccount_thenSaveIt() {
        //Given
        when(accountRepository.load(any(UUID.class))).thenReturn(java.util.Optional.of(new Account(UUID.randomUUID(), BigDecimal.valueOf(1000))));
        //When
        tested.withdraw(UUID.randomUUID(), BigDecimal.valueOf(500));
        //Then
        verify(accountRepository).save(any(Account.class));
    }

}