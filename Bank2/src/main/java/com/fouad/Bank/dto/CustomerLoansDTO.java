package com.fouad.Bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class CustomerLoansDTO {

    private Date startDate;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

}
