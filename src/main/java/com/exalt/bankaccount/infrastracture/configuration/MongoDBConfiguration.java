package com.exalt.bankaccount.infrastracture.configuration;

import com.exalt.bankaccount.infrastracture.repository.mongo.SpringDataMongoAccountRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoAccountRepository.class)
public class MongoDBConfiguration {
}
