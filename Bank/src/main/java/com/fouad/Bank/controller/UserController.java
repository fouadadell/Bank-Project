package com.fouad.Bank.controller;

import com.fouad.Bank.dto.MessageResponseDTO;
import com.fouad.Bank.dto.RegisterRequestDTO;
import com.fouad.Bank.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<MessageResponseDTO> register(@RequestBody RegisterRequestDTO customerRegistration) {
       return  userService.register(customerRegistration);
    }

    @GetMapping("/user")
    public ResponseEntity<RegisterRequestDTO> getUser(Authentication authentication) {
        return  userService.getCustomer(authentication);
    }

    @PatchMapping("/edit")
    public ResponseEntity<MessageResponseDTO> EditUser(Authentication authentication,@RequestBody RegisterRequestDTO  customerFields) {
        return  userService.updateCustomer(authentication,customerFields);
    }
}
