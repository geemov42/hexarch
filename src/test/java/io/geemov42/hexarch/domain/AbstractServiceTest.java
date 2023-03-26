package io.geemov42.hexarch.domain;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = NoControllerSpringBootApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public abstract class AbstractServiceTest {

}
