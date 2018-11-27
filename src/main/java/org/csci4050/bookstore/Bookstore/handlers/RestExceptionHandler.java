package org.csci4050.bookstore.Bookstore.handlers;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Reference: https://www.toptal.com/java/spring-boot-rest-api-error-handling
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(final ValidationException ve) {
        return handleException(ve);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleDatabaseException(final DataAccessException da) {
        return handleException(da);
    }

    private ResponseEntity<Object> handleException(final Exception e) {
        System.out.println(e);
        final ExceptionModel exceptionModel = ExceptionModel.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(exceptionModel, HttpStatus.NOT_FOUND);
    }

    @Data
    @Builder
    public static class ExceptionModel {
        private HttpStatus status;
        private String message;
    }
}
