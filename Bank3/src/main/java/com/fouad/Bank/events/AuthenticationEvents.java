package com.fouad.Bank.events;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
public class AuthenticationEvents {

    @EventListener
    public void onAuthenticationSuccessEvent(AuthenticationSuccessEvent successEvent) {
        log.info("Login successful for the user : {}", successEvent.getAuthentication().getName());
    }
    @EventListener
    public void onAuthenticationFailureEvent(AbstractAuthenticationFailureEvent failureEvent) {
        log.error("Login failed for the user : {} due to : {}", failureEvent.getAuthentication().getName(),
                failureEvent.getException().getMessage());    }
}
