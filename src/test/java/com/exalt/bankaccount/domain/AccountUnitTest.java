package com.exalt.bankaccount.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountUnitTest {

    @Test
    void should_create_account() {
        //When
        final Account account = AccountProvider.getCreatedAccount();
        //Then
        assertNotNull(account);
        assertEquals(BigDecimal.valueOf(1000), account.getBalance());
    }


    @ParameterizedTest
    @ValueSource(longs = {100, 200, 300, 400, 500})
    void should_deposit_and_update_balance(long value) {
        //Given
        final Account account = AccountProvider.getCreatedAccount();
        //When
        account.deposit(BigDecimal.valueOf(value));
        //Then
        assertEquals(BigDecimal.valueOf(1000+value), account.getBalance());
    }

    @ParameterizedTest
    @ValueSource(longs = {100, 200, 300, 400, 500})
    void should_withdraw_and_update_balance(long value) {
        //Given
        final Account account = AccountProvider.getCreatedAccount();
        //When
        account.withdraw(BigDecimal.valueOf(value));
        //Then
        assertEquals(BigDecimal.valueOf(1000-value), account.getBalance());
    }

}