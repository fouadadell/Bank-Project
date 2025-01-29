package com.fouad.Bank.service;

import com.fouad.Bank.dto.AccountDetailsDTO;
import com.fouad.Bank.dto.AccountTransactionsDTO;
import com.fouad.Bank.model.Accounts;
import com.fouad.Bank.model.Customer;
import com.fouad.Bank.repository.AccountRepository;
import com.fouad.Bank.repository.CustomerRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Data
@Slf4j
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final CustomerRepository customerRepository;

   public ResponseEntity<AccountDetailsDTO> getAccount(String email, String accountNumber) {
       Optional<Customer> customer = customerRepository.findByEmail(email);
       AccountDetailsDTO accountDetailsDTO = new AccountDetailsDTO();
       if (customer.isEmpty()) {
           accountDetailsDTO.setMessage("User not found");
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accountDetailsDTO);
       }
       Optional<Accounts> accounts = accountRepository.findByAccountNumber(accountNumber);
       if (accounts.isEmpty()) {
           accountDetailsDTO.setMessage("Account not found");
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accountDetailsDTO);
       }
       accountDetailsDTO.setAccountNumber(accounts.get().getAccountNumber());
       accountDetailsDTO.setAccountType(accounts.get().getAccountType());
       accountDetailsDTO.setCustomerName(customer.get().getCustomerName());
       accountDetailsDTO.setBranchName(accounts.get().getBranches().getBranchName());
       accountDetailsDTO.setMessage("Account found");
       return ResponseEntity.status(HttpStatus.OK).body(accountDetailsDTO);
   }


    public ResponseEntity<List<AccountTransactionsDTO>> getAccountTransactions(String email, String accountNumber) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        AccountTransactionsDTO accountTransactionsDTO = new AccountTransactionsDTO();
        if (customer.isEmpty()) {
            accountTransactionsDTO.setMessage("User not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Arrays.asList(accountTransactionsDTO));
        }
        Optional<Accounts> account = accountRepository.findByAccountNumber(accountNumber);
        if (account.isEmpty()) {
            accountTransactionsDTO.setMessage("Account not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Arrays.asList(accountTransactionsDTO));
        }
        List<AccountTransactionsDTO> accountTransactionsDTOs =new ArrayList<>();
         accountTransactionsDTOs=account.get().getTransactions().stream()
                .map(transactions -> new AccountTransactionsDTO(
                        transactions.getTransactionDate(),
                        transactions.getTransactionSummary(),
                        transactions.getTransactionType(),
                        transactions.getTransactionAmt(),
                        transactions.getClosingBalance(),
                        "Transactions successfully retrieved")).toList();
         log.info(accountTransactionsDTOs.toString());
        return ResponseEntity.status(HttpStatus.OK).body(accountTransactionsDTOs);
    }
}
