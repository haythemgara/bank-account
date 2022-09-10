package com.exalt.bankaccount.infrastracture.repository.mongo;

import com.exalt.bankaccount.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoAccountRepository extends MongoRepository<Account, UUID> {
}
