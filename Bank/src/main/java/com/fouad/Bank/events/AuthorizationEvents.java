package com.fouad.Bank.events;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationEvent;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
public class AuthorizationEvents {
    @EventListener
    public void onAuthorizationFailureEvent(AuthorizationEvent deniedEvent) {
        log.error("Authorization failed for the user : {} due to : {}",
                deniedEvent.getAuthentication().get().getName(), deniedEvent.getAuthorizationResult().toString());
    }
}
