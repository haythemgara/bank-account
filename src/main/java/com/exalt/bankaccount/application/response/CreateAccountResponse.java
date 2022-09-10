package com.exalt.bankaccount.application.response;

public class CreateAccountResponse {
    private final Long id;

    public CreateAccountResponse(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
