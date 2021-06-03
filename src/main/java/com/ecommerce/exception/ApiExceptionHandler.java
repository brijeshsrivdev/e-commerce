package com.ecommerce.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Api exception handler.
 */
@RestControllerAdvice
public class ApiExceptionHandler extends RuntimeException{


    /**
     * Handle response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e) {
        ErrorResponse errors = new ErrorResponse();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            ErrorItem error = new ErrorItem();
            error.setCode(violation.getMessageTemplate());
            error.setMessage(violation.getMessage());
            errors.addError(error);
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorItem> handle(ResourceNotFoundException e) {
        ErrorItem error = new ErrorItem();
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorItem> handleGenericNotFoundException(NotFoundException e) {
        ErrorItem error = new ErrorItem();
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * The type Error item.
     */
    public static class ErrorItem {

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String code;

        private String message;

        /**
         * Gets code.
         *
         * @return the code
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets code.
         *
         * @param code the code
         */
        public void setCode(String code) {
            this.code = code;
        }

        /**
         * Gets message.
         *
         * @return the message
         */
        public String getMessage() {
            return message;
        }

        /**
         * Sets message.
         *
         * @param message the message
         */
        public void setMessage(String message) {
            this.message = message;
        }

    }

    /**
     * The type Error response.
     */
    public static class ErrorResponse {

        private List<ErrorItem> errors = new ArrayList<>();

        /**
         * Gets errors.
         *
         * @return the errors
         */
        public List<ErrorItem> getErrors() {
            return errors;
        }

        /**
         * Sets errors.
         *
         * @param errors the errors
         */
        public void setErrors(List<ErrorItem> errors) {
            this.errors = errors;
        }

        /**
         * Add error.
         *
         * @param error the error
         */
        public void addError(ErrorItem error) {
            this.errors.add(error);
        }

    }
}
