package com.example.online_shopping.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("springSecurityAuditorAware")  // Explicitly naming the bean
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Get the authenticated user's name (username)
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return Optional.ofNullable(username); // Return the username
    }
}
