package com.fouad.Bank.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.AuthenticationException;
@Configuration
@AllArgsConstructor
public class CustomBankAuthenticationManager implements AuthenticationManager {

   private final CustomBankUserNameAuthenticationProvider customBankUserNameAuthenticationProvider;
   @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return customBankUserNameAuthenticationProvider.authenticate(authentication);
    }
}
