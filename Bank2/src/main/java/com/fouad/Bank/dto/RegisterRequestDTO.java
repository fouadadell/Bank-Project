package com.fouad.Bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class RegisterRequestDTO {
    private String customerName;

    private String email;

    private String mobileNumber;

    private String address;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;
}
