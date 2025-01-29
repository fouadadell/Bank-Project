package com.fouad.Bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Entity
@Data
@Slf4j
public class Branches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;
    private String branchName;
    private String branchAddress;

    @OneToMany(mappedBy = "branches", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Accounts> accounts;
}
