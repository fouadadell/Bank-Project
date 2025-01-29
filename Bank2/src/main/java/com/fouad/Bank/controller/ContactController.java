package com.fouad.Bank.controller;

import com.fouad.Bank.dto.ContactDTO;
import com.fouad.Bank.dto.ResponseDTO;
import com.fouad.Bank.service.ContactsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContactController {
    private final ContactsService contactsService;

    @PostMapping("/contact")
    public ResponseEntity<ResponseDTO> saveContactInquiryDetails(@RequestBody ContactDTO contact) {
      return   contactsService.saveContact(contact);
    }


}
