package com.fouad.Bank.service;

import com.fouad.Bank.dto.MessageResponseDTO;
import com.fouad.Bank.dto.RegisterRequestDTO;
import com.fouad.Bank.model.Customer;
import com.fouad.Bank.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@Data
public class UserService {

    @Autowired
    private final CustomerRepository customerRepository;


    public ResponseEntity<RegisterRequestDTO> getCustomer(String email ) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        RegisterRequestDTO user = new RegisterRequestDTO();
        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        user.setCustomerName(optionalCustomer.get().getCustomerName());
        user.setEmail(optionalCustomer.get().getEmail());
        user.setMobileNumber(optionalCustomer.get().getMobileNumber());
        user.setAddress(optionalCustomer.get().getAddress());
        return ResponseEntity.status(HttpStatus.OK)
                .body(user);
    }

    public ResponseEntity<MessageResponseDTO> updateCustomer(String email, @RequestBody RegisterRequestDTO customerFields) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        MessageResponseDTO editedResponseMessage = new MessageResponseDTO();
        if (customerFields.getCustomerName() != null)
            optionalCustomer.get().setCustomerName(customerFields.getCustomerName());
        if (customerFields.getMobileNumber() != null)
            optionalCustomer.get().setMobileNumber(customerFields.getMobileNumber());
        if (customerFields.getEmail() != null) optionalCustomer.get().setEmail(customerFields.getEmail());
        if (customerFields.getAddress() != null) optionalCustomer.get().setAddress(customerFields.getAddress());
        customerRepository.save(optionalCustomer.get());
        editedResponseMessage.setMessage("Given user details are successfully updated");
        return ResponseEntity.status(HttpStatus.OK).body(editedResponseMessage);
    }


}
