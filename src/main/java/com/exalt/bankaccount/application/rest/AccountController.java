package com.exalt.bankaccount.application.rest;

import com.exalt.bankaccount.application.request.CreateAccountRequest;
import com.exalt.bankaccount.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/createAccount")
    public void createAccount(@RequestBody final CreateAccountRequest createAccountRequest) {
        accountService.depositOrCreateNew(createAccountRequest.getId(), createAccountRequest.getBalance());
    }

    @PostMapping(value = "/{id}/depositOrCreateNew/{amount}")
    public void deposit(@PathVariable final UUID id, @PathVariable final BigDecimal amount) {
        accountService.depositOrCreateNew(id, amount);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    public void withdraw(@PathVariable final UUID id, @PathVariable final BigDecimal amount) {
        accountService.withdraw(id, amount);
    }
}
