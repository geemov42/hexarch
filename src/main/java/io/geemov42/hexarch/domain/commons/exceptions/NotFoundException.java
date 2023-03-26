package io.geemov42.hexarch.domain.commons.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    protected final String reason;

    public NotFoundException(String reason, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

        this.reason = reason;
    }
}
