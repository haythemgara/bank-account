package com.exalt.bankaccount.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class CreateAccountRequest {
    private UUID id;
    private BigDecimal balance;

    @JsonCreator
    public CreateAccountRequest(@JsonProperty("id") final UUID id, @JsonProperty("balance") @NotNull final BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

}
