package com.example.springboot.employee_rest_app.exception;

import com.example.springboot.employee_rest_app.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionResponse> handleException(EmployeeNotFoundException exc) {

        EmployeeExceptionResponse error = new EmployeeExceptionResponse(
                                        HttpStatus.NOT_FOUND.value(),
                                        exc.getMessage(),
                                        LocalDateTime.now().toString());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionResponse> handleException(Exception exc) {

        EmployeeExceptionResponse error = new EmployeeExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                LocalDateTime.now().toString());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
