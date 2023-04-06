package io.geemov42.hexarch.infrastructure.business.todo;

import io.geemov42.hexarch.domain.business.todo.outbound.ExternalTodoService;
import io.geemov42.hexarch.infrastructure.outbound.jsonplaceholderservice.JsonPlaceHolderServiceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExternalTodoServiceAdapter implements ExternalTodoService {

    private final JsonPlaceHolderServiceAdapter jsonPlaceHolderServiceAdapter;

    @Override
    public Optional<String> getRandomTodo() {
        return jsonPlaceHolderServiceAdapter.getRandomTodo();
    }
}
