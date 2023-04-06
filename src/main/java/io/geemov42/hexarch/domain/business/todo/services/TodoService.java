package io.geemov42.hexarch.domain.business.todo.services;

import io.geemov42.hexarch.domain.business.todo.TodoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    Optional<TodoEntity> findTodoById(int id);

    List<TodoEntity> findAllTodos();

    List<TodoEntity> findAllTodos(int page, int numItems);

    TodoEntity createTodo(String title, String description);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    TodoEntity createRandomTodo();

    TodoEntity markTodoAsResolved(int idTodo);

    void deleteTodo(int idTodo);
}
