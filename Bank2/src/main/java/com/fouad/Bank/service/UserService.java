package com.fouad.Bank.service;

import com.fouad.Bank.dto.MessageResponseDTO;
import com.fouad.Bank.dto.RegisterRequestDTO;
import com.fouad.Bank.model.Customer;
import com.fouad.Bank.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
@Data
public class UserService {

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<MessageResponseDTO> register(RegisterRequestDTO customerRegistration) {
        MessageResponseDTO registerResponseDTO = new MessageResponseDTO();
        Customer newCustomer = new Customer();
        try {
            String hashPassword = passwordEncoder.encode(customerRegistration.getPwd());
            newCustomer.setCustomerName(customerRegistration.getCustomerName());
            newCustomer.setEmail(customerRegistration.getEmail());
            newCustomer.setMobileNumber(customerRegistration.getMobileNumber());
            newCustomer.setPwd(hashPassword);
            newCustomer.setCreatedAt(new Date(System.currentTimeMillis()));
            newCustomer = customerRepository.save(newCustomer);
            if (newCustomer.getCustomerId() > 0) {
                registerResponseDTO.setMessage("Given user details are successfully registered");
                return ResponseEntity.status(HttpStatus.CREATED).
                        body(registerResponseDTO);
            } else {
                registerResponseDTO.setMessage("User registration failed");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(registerResponseDTO);
            }
        } catch (Exception e) {
            registerResponseDTO.setMessage("An Exception occurred due to : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(registerResponseDTO);
        }
    }

    public ResponseEntity<RegisterRequestDTO> getCustomer(String email) {
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

    public ResponseEntity<MessageResponseDTO> updateCustomer(String email,  RegisterRequestDTO customerFields) {
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
