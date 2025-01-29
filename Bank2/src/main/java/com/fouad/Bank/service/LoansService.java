package com.fouad.Bank.service;

import com.fouad.Bank.dto.CustomerLoansDTO;
import com.fouad.Bank.model.Customer;
import com.fouad.Bank.model.CustomersLoans;
import com.fouad.Bank.model.Loans;
import com.fouad.Bank.repository.CustomerLoansRepository;
import com.fouad.Bank.repository.CustomerRepository;
import com.fouad.Bank.repository.LoansRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class LoansService {
    private final LoansRepository loanRepository;

    private final CustomerRepository customerRepository;

    private final CustomerLoansRepository customerLoansRepository;

    public List<CustomerLoansDTO> getCustomerLoans(String customerEmail){
        Optional<Customer> customer = customerRepository.findByEmail(customerEmail);
       List<CustomersLoans> customersLoans = customerLoansRepository.findByCustomerCustomerId(
               customer.get().getCustomerId()
       );
       List<Loans> loans= customersLoans.stream().map(
               customersLoans1 -> customersLoans1.getLoans()).toList();
       return loans.stream().map(loan -> new CustomerLoansDTO(
               loan.getStartDate(),
               loan.getLoanType(),
               loan.getTotalLoan(),
               loan.getAmountPaid(),
               loan.getOutstandingAmount()
       )).toList();
  }
}
