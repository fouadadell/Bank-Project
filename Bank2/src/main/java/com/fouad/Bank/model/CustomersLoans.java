package com.fouad.Bank.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
public class CustomersLoans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId", nullable = false)

    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_id", referencedColumnName = "loanId", nullable = false)
    private Loans loans;
}
