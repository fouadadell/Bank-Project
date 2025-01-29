package com.fouad.Bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ContactDTO {

    private String contactName;

    private String contactEmail;

    private String contactSubject;

    private String contactMessage;

}
