package com.fouad.Bank.service;

import com.fouad.Bank.dto.ContactDTO;
import com.fouad.Bank.dto.ResponseDTO;
import com.fouad.Bank.model.Contact;
import com.fouad.Bank.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@AllArgsConstructor
public class ContactsService {
    private final ContactRepository contactRepository;
    public ResponseEntity<ResponseDTO> saveContact(ContactDTO contactDTo) {
        Contact contact=new Contact();
        contact.setContactEmail(contactDTo.getContactEmail());
        contact.setContactSubject(contactDTo.getContactSubject());
        contact.setContactName(contactDTo.getContactName());
        contact.setContactMessage(contactDTo.getContactMessage());
        contact.setCreatedAt(new Date(System.currentTimeMillis()));
        contactRepository.save(contact);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO("Contact saved successfully"));
    }
}
