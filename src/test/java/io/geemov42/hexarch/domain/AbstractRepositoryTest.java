package io.geemov42.hexarch.domain;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles({"test"})
@ComponentScan({
        "io.geemov42.hexarch.domain",
        "io.geemov42.hexarch.infrastructure"
})
public abstract class AbstractRepositoryTest {

}
