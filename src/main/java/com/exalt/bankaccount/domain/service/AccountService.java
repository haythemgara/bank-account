package com.exalt.bankaccount.domain.service;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountService {

    void depositOrCreateNew(UUID id, BigDecimal amount);

    boolean withdraw(UUID id, BigDecimal amount);

}
