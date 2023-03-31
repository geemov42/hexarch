package io.geemov42.hexarch.application.business.api;

import io.geemov42.hexarch.domain.business.todo.TodoEntity;
import io.geemov42.hexarch.infrastructure.business.todo.TodoEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles(profiles = {
        "test",
})
class TodoControllerFunctionalTest extends AbstractFunctionalTest {

    @Autowired
    private TodoEntityRepository todoEntityRepository;

    @Test
    @Sql(
            statements = {
                    """
                    INSERT INTO todo_table_aud (revtype, created_by, created_date, last_modified_by, last_modified_date, description, resolved, content, id, rev)
                    VALUES (1, 'UNKNOWN', '2023-03-30 20:20:37.336', 'UNKNOWN',	'2023-03-30 20:20:37.336', 'a desc', FALSE, 'custom', 0, 0);
                    """
            }
    )
    void findTodoById() throws Exception {

//        Given
        this.todoEntityRepository.save(TodoEntity.builder()
                .title("custom")
                .description("a desc")
                .build());
//        Then
        this.mockMvc.perform(get(this.baseUri + "/todo"))
                .andExpect(status().isOk());
    }

    @Test
    void findAllTodos() {
    }

    @Test
    void testFindAllTodos() {
    }

    @Test
    void createTodo() {
    }

    @Test
    void markTodoAsResolved() {
    }

    @Test
    void deleteTodo() {
    }
}