package com.fouad.Bank.repository;

import com.fouad.Bank.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  LoansRepository extends JpaRepository<Loans,Long> {
    List<Loans> findByLoanId(long loanId);
}
