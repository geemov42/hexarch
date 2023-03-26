package io.geemov42.hexarch.infrastructure.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

class SpringSecurityAuditorAware implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {

        return Optional.of("UNKNOWN");
    }
}
