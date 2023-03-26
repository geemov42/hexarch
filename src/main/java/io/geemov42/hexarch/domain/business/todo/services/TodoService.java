package io.geemov42.hexarch.domain.business.todo.services;

import io.geemov42.hexarch.domain.business.todo.TodoEntity;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    Optional<TodoEntity> findTodoById(int id);

    List<TodoEntity> findAllTodos();

    List<TodoEntity> findAllTodos(int page, int numItems);

    TodoEntity createTodo(String title, String description);

    TodoEntity markTodoAsResolved(int idTodo);

    void deleteTodo(int idTodo);
}
