package com.example.online_shopping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")  // Referencing the custom bean
public class JpaConfig {
    // This enables automatic auditing and uses the custom AuditorAware bean
}
