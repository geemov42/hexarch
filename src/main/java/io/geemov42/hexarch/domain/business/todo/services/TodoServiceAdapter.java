package io.geemov42.hexarch.domain.business.todo.services;

import io.geemov42.hexarch.domain.business.todo.TodoEntity;
import io.geemov42.hexarch.domain.business.todo.exceptions.TodoNotFoundException;
import io.geemov42.hexarch.domain.business.todo.outbound.EboxService;
import io.geemov42.hexarch.infrastructure.business.todo.TodoEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceAdapter implements TodoService {

    // Never add repository of other domain, call only service layer
    private final TodoEntityRepository todoEntityRepository;
    private final EboxService eboxService;

    @Override
    public Optional<TodoEntity> findTodoById(int id) {

        int numberOfAvailableMessage = this.eboxService.countNumberOfAvailableMessage("ssinvalue");
        log.info("We found {} messages", numberOfAvailableMessage);

        return this.todoEntityRepository.findById(id);
    }

    @Override
    public List<TodoEntity> findAllTodos() {

        return this.todoEntityRepository.findAll();
    }

    @Override
    public List<TodoEntity> findAllTodos(int page, int numItems) {

        return this.todoEntityRepository.findAll(Pageable.ofSize(numItems).withPage(page)).getContent();
    }

    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    public TodoEntity createTodo(String title, String description) {

        TodoEntity newTodo = TodoEntity.builder()
                .title(title)
                .description(description)
                .build();

        this.todoEntityRepository.save(newTodo);

        return newTodo;
    }

    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    public TodoEntity markTodoAsResolved(int idTodo) {

        TodoEntity todoEntity = this.todoEntityRepository
                .findById(idTodo)
                .orElseThrow(() -> TodoNotFoundException.builder().reason("Todo " + idTodo + " not found").build());

        todoEntity.setResolved(true);

        return todoEntity;
    }

    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    public void deleteTodo(int idTodo) {

        this.todoEntityRepository.deleteById(idTodo);
    }
}
