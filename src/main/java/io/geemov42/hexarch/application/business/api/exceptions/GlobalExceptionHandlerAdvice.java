package io.geemov42.hexarch.application.business.api.exceptions;

import io.geemov42.hexarch.domain.commons.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        log.error(String.format("Request %s raised exception", request.toString()), ex);

        headers.add(HttpHeaders.CONTENT_TYPE, "application/problem+json");

        if (!(body instanceof Map)) {

            Map<String, Object> responseException = Map.of(
                    "reason", ex.getMessage(),
                    "status", status.value()
            );

            return super.handleExceptionInternal(ex, responseException, headers, status, request);
        } else {
            return super.handleExceptionInternal(ex, body, headers, status, request);
        }
    }

    @ExceptionHandler({Exception.class})
    @Nullable
    public final ResponseEntity<Object> handleOtherException(Exception ex, WebRequest request) {

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        Map<String, Object> responseException = Map.of(
                "reason", ex.getMessage(),
                "status", status.value()
        );

        return handleExceptionInternal(ex, responseException, headers, status, request);
    }

    @ExceptionHandler({NotFoundException.class})
    @Nullable
    public final ResponseEntity<Object> handleBusinessException(NotFoundException ex, WebRequest request) {

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.NOT_FOUND;

        Map<String, Object> responseException = Map.of(
                "reason", ex.getReason(),
                "status", status.value()
        );

        return handleExceptionInternal(ex, responseException, headers, status, request);
    }
}
