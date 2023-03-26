package io.geemov42.hexarch.application.business.api.controllers;

import io.geemov42.hexarch.application.business.api.controllers.mappers.TodoDtoMapTodoEntityMapper;
import io.geemov42.hexarch.application.business.api.controllers.model.TodoDto;
import io.geemov42.hexarch.domain.business.todo.TodoEntity;
import io.geemov42.hexarch.domain.business.todo.exceptions.TodoNotFoundException;
import io.geemov42.hexarch.domain.business.todo.services.TodoService;
import io.geemov42.hexarch.infrastructure.business.todo.TodoEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
@Slf4j
public class TodoController {

    private final HttpServletRequest request;
    private final TodoService todoService;
    private final TodoEntityRepository todoEntityRepository;
    private final TodoDtoMapTodoEntityMapper todoDtoMapTodoEntityMapper;

    @PostConstruct
    public void init() {

        this.todoEntityRepository.save(TodoEntity.builder()
                .title("custom")
                .description("a desc")
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> findTodoById(@PathVariable("id") int idTodo) {

        TodoEntity todoEntity = this.todoService.findTodoById(idTodo)
                .orElseThrow(() -> TodoNotFoundException.builder().reason("Todo " + idTodo + " not found").build());

        return ResponseEntity.ok(this.todoDtoMapTodoEntityMapper.toDataObject(todoEntity));
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> findAllTodos() {

        List<TodoEntity> todoEntity = this.todoService.findAllTodos();

        return ResponseEntity.ok((List<TodoDto>) this.todoDtoMapTodoEntityMapper.toDataObjects(todoEntity));
    }

    @GetMapping("/pageable")
    public ResponseEntity<List<TodoDto>> findAllTodos(@RequestParam("page") int page, @RequestParam(value = "numItems", defaultValue = "10") int numItems) {

        List<TodoEntity> todoEntity = this.todoService.findAllTodos(page, numItems);

        return ResponseEntity.ok((List<TodoDto>) this.todoDtoMapTodoEntityMapper.toDataObjects(todoEntity));
    }

    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestParam("title") String title, @RequestParam("description") String description) {

        TodoEntity todoEntity = this.todoService.createTodo(title, description);

        return ResponseEntity.ok(this.todoDtoMapTodoEntityMapper.toDataObject(todoEntity));
    }

    @PutMapping("/resolve/{id}")
    public ResponseEntity<TodoDto> markTodoAsResolved(@PathVariable("id") int idTodo) {

        TodoEntity todoEntity = this.todoService.markTodoAsResolved(idTodo);

        return ResponseEntity.ok(this.todoDtoMapTodoEntityMapper.toDataObject(todoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") int idTodo) {

        this.todoService.deleteTodo(idTodo);

        return ResponseEntity.ok().build();
    }
}
