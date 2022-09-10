package com.exalt.bankaccount.infrastracture.configuration;

import com.exalt.bankaccount.DomainLayerApplication;
import com.exalt.bankaccount.domain.repository.AccountRepository;
import com.exalt.bankaccount.domain.service.AccountService;
import com.exalt.bankaccount.domain.service.DomainAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DomainLayerApplication.class)
public class BeanConfiguration {

    @Bean
    AccountService accountService(final AccountRepository accountRepository) {
        return new DomainAccountService(accountRepository);
    }
}
