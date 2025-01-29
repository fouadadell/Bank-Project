package com.fouad.Bank.repository;

import com.fouad.Bank.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByAccountId(long customerId);
    Optional<Accounts>   findByAccountNumber(String accountNumber);
}
