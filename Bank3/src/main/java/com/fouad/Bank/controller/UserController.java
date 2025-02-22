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


    @GetMapping("/user")
    public ResponseEntity<RegisterRequestDTO> getUser(@RequestParam("email")String email){
        return  userService.getCustomer(email);
    }

    @PatchMapping("/edit")
    public ResponseEntity<MessageResponseDTO> EditUser(@RequestParam("email")String email,@RequestBody RegisterRequestDTO  customerFields) {
        return  userService.updateCustomer(email,customerFields);
    }
}
