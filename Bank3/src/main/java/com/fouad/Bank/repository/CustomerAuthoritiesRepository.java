package com.fouad.Bank.repository;

import com.fouad.Bank.model.CustomerAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAuthoritiesRepository extends JpaRepository<CustomerAuthorities, Long> {
}
