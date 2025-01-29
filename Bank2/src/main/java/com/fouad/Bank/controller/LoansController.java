package com.fouad.Bank.controller;

import com.fouad.Bank.dto.CustomerLoansDTO;
import com.fouad.Bank.service.LoansService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
public class LoansController {
    @Autowired
    private final LoansService loansService;

    @GetMapping("/myLoans")
    public List<CustomerLoansDTO> getLoanDetails(@RequestParam("email") String customerEmail) {
        return loansService.getCustomerLoans(customerEmail);

    }
}
