package com.fouad.Bank.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Slf4j
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    private String accountNumber;

    private String accountType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id", referencedColumnName = "branchId", nullable = false)
    private Branches branches;

    private Date createdAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "accounts",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transactions> transactions;
}
