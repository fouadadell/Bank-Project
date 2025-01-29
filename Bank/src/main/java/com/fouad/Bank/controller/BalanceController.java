package com.fouad.Bank.controller;

import com.fouad.Bank.dto.AccountTransactionsDTO;
import com.fouad.Bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired private AccountService accountsService;
    @GetMapping("/myBalance")
    public ResponseEntity<List<AccountTransactionsDTO>> getAccountTransactionsDetails(Authentication authentication,
                                                                                      @RequestParam("accountNumber")String accountNumber) {
        return accountsService.getAccountTransactions(authentication,accountNumber);
    }
}
