package com.fouad.Bank.dto;

import lombok.Data;

@Data
public class AccountDetailsDTO {
    private String accountNumber;
    private String accountType;
    private String customerName;
    private String branchName;
    private String message;
}
