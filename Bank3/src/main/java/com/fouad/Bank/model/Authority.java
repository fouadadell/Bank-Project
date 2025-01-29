package com.fouad.Bank.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Entity
@Data
@Slf4j
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorityId;

    private String authorityName;

    @OneToMany(mappedBy = "authority",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerAuthorities> customerAuthorities;

}
