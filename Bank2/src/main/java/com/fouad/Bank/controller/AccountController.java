package com.fouad.Bank.controller;

import com.fouad.Bank.dto.AccountDetailsDTO;
import com.fouad.Bank.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Data
public class AccountController {

    @Autowired
    private final AccountService accountsService;

    @GetMapping("/myAccount")
    public ResponseEntity<AccountDetailsDTO> getAccountDetails(
            @RequestParam("email")String email,
            @RequestParam("accountNumber")String accountNumber) {
        return accountsService.getAccount(email,accountNumber);
    }



}
