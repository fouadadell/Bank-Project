package com.fouad.Bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Entity
@Data
@Slf4j
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId", nullable = false)
    private Accounts accounts;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    private Date transactionDate;

    private String transactionSummary;

    private String transactionType;

    private int transactionAmt;

    private int closingBalance;

    private Date createdAt;
}
