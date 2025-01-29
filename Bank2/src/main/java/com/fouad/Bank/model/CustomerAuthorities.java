package com.fouad.Bank.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
public class CustomerAuthorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "authority_id", referencedColumnName = "authorityId", nullable = false)
    private Authority authority ;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId", nullable = false)
    private Customer customer ;
}
