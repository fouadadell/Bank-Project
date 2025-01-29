package com.fouad.Bank.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Slf4j
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;

    private Date startDate;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

    private Date createdAt;

    @OneToMany(mappedBy = "loans", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomersLoans> customersLoans;

}
