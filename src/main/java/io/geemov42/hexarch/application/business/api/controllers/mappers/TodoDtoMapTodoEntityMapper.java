package io.geemov42.hexarch.application.business.api.controllers.mappers;

import io.geemov42.hexarch.application.business.api.controllers.model.TodoDto;
import io.geemov42.hexarch.domain.business.todo.TodoEntity;
import io.geemov42.hexarch.domain.commons.mappers.GenericMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface TodoDtoMapTodoEntityMapper extends GenericMapper<TodoDto, TodoEntity> {
}
