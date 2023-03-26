package io.geemov42.hexarch.application.business.api.controllers;

import io.geemov42.hexarch.application.configuration.HealthStatusKeeper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class HealthController {

    public static final String DEGRADED = "DEGRADED";
    public static final String UP = "UP";
    private final HealthStatusKeeper healthStatusKeeper;

//    @Override
//    public ResponseEntity<HealthStatus> checkHealth() {
//
//        var healthStatus = this.healthStatusKeeper.getHealthStatus();
//
//        if (healthStatus.getStatus().getCode().equals(Status.UP.getCode())) {
//            return ResponseEntity.ok(new HealthStatus().status(UP));
//        } else {
//            return ResponseEntity.ok(new HealthStatus().status(DEGRADED));
//        }
//    }
}
