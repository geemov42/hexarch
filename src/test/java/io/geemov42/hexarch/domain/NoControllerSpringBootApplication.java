package io.geemov42.hexarch.domain;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "io.geemov42.hexarch.domain",
                "io.geemov42.hexarch.infrastructure",
        }
)
public class NoControllerSpringBootApplication {
}
