package io.geemov42.hexarch.infrastructure.outbound.jsonplaceholderservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@Slf4j
public class JsonPlaceHolderServiceAdapter {

    public Optional<String> getRandomTodo() {

        int randomId = 0;
        try {
            randomId = SecureRandom.getInstanceStrong().nextInt(200);

            // Make an external call, don't care in this context about the result
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<ExternalTodo> entity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/{id}", ExternalTodo.class, Map.of("id", randomId));

            if (nonNull(entity.getBody())) {
                return Optional.ofNullable(entity.getBody().getTitle());
            } else {
                return Optional.empty();
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
