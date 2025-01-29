package com.fouad.Bank.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Entity
@Data
@Slf4j
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String contactId;

    private String contactName;

    private String contactEmail;

    private String contactSubject;

    private String contactMessage;

    private Date createdAt;

}

