package io.geemov42.hexarch.infrastructure.business.todo;

import io.geemov42.hexarch.domain.business.todo.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoEntityRepository extends JpaRepository<TodoEntity, Integer> {

}
