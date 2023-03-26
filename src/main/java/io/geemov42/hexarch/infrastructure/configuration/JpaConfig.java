package io.geemov42.hexarch.infrastructure.configuration;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "io.geemov42.hexarch.infrastructure.business")
@EntityScan(basePackages = "io.geemov42.hexarch.domain.business")
@AllArgsConstructor
public class JpaConfig {

    @Bean
    public Hibernate5Module initHibernate5Module() {
        return new Hibernate5Module();
    }
}
