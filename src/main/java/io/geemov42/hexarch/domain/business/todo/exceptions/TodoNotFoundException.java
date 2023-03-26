package io.geemov42.hexarch.domain.business.todo.exceptions;

import io.geemov42.hexarch.domain.commons.exceptions.NotFoundException;
import lombok.Builder;

public class TodoNotFoundException extends NotFoundException {

    @Builder
    public TodoNotFoundException(String reason, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(reason, message, cause, enableSuppression, writableStackTrace);
    }
}
