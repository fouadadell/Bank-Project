package com.fouad.Bank.repository;

import com.fouad.Bank.model.Customer;
import com.fouad.Bank.model.CustomersLoans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    List<CustomersLoans> findCustomerLoansByEmail(String email);
}
