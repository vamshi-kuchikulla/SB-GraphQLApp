package com.cst.graphQl.handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDetails> constraintViolationException(ConstraintViolationException ex){
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDate.now())
                .details("Constraint Violated!!!!!")
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundError(StudentNotFoundException ex, WebRequest request){
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDate.now())
                .details(request.getDescription(false))
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
}
