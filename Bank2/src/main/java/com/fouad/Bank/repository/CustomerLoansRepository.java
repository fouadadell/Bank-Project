package com.fouad.Bank.repository;

import com.fouad.Bank.model.CustomersLoans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerLoansRepository extends JpaRepository<CustomersLoans, Long> {
   List<CustomersLoans> findByCustomerCustomerId(long id);
}
