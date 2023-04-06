package io.geemov42.hexarch.domain.business.todo.outbound;

import java.util.Optional;

public interface ExternalTodoService {

    Optional<String> getRandomTodo();
}
