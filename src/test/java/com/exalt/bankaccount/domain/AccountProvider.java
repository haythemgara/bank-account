package com.exalt.bankaccount.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountProvider {
    public static Account getCreatedAccount() {
        return new Account(UUID.randomUUID(), BigDecimal.valueOf(1000));
    }
}
