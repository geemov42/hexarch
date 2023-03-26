package io.geemov42.hexarch.infrastructure.business.todo;

import io.geemov42.hexarch.domain.AbstractRepositoryTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class TodoEntityRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private TodoEntityRepository todoEntityRepository;

    @Test
    @Sql(statements = "insert into todo_table (created_by, created_date, last_modified_by, last_modified_date, description, resolved, content, version, id) \n" +
            " values ('admin', null, 'admin', null, 'a desc', false, 'cool todo', 1, 5000);")
    void findById() {

        var todoEntityOptional = this.todoEntityRepository.findById(5000);

        Assertions.assertTrue(todoEntityOptional.isPresent());
    }
}
