package com.exalt.bankaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:bankaccount.properties"})
public class DomainLayerApplication {

    public static void main(final String[] args) {
        new SpringApplication(DomainLayerApplication.class);
    }

}
