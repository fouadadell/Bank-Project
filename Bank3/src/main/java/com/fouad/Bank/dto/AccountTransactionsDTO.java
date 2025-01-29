package com.fouad.Bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransactionsDTO {
   private Date transactionDate;

   private String transactionSummary;

   private String transactionType;

   private int transactionAmt;

   private int closingBalance;

   private String message;
}
