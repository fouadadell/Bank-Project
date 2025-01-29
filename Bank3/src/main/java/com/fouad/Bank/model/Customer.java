package com.fouad.Bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    private String customerName;

    private String email;

    private String mobileNumber;

    private String address ;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private Date createdAt;

    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerAuthorities> CustomerAuthorities;

    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Accounts> accounts;

    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cards> cards;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomersLoans> customersLoans;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transactions> transactions;
}
