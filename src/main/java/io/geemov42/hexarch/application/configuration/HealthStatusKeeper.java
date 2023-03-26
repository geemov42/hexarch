package io.geemov42.hexarch.application.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.CompositeHealth;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.SystemHealth;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static org.springframework.boot.actuate.health.Status.UP;

/**
 * This class keep the health status up to date to answer quickly to monitoring
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class HealthStatusKeeper {

    private final HealthEndpoint healthEndpoint;

    private CompositeHealth systemHealth = null;

    @Scheduled(initialDelay = 60000, fixedRate = 60000)
    private void healthCheck() {

        this.systemHealth = (CompositeHealth) this.healthEndpoint.health();

        //Log if the healthCheck show problems
        if (this.systemHealth != null && !this.systemHealth.getStatus().getCode().equals(UP.getCode())) {
            log.error("The healthCheck failed {}", this.systemHealth.getComponents());
        }
    }

    public SystemHealth getHealthStatus() {

        if (this.systemHealth == null || !this.systemHealth.getStatus().getCode().equals(UP.getCode())) {
            this.healthCheck();
        }

        return (SystemHealth) this.systemHealth;
    }

    public CompositeHealth getHealthDetails() {

        if (this.systemHealth == null || !this.systemHealth.getStatus().getCode().equals(UP.getCode())) {
            this.healthCheck();
        }

        return this.systemHealth;
    }
}
