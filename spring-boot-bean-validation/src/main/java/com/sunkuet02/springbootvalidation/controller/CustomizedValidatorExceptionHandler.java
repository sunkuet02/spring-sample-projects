package com.sunkuet02.springbootvalidation.controller;

import com.sunkuet02.springbootvalidation.dto.response.Metadata;
import com.sunkuet02.springbootvalidation.dto.response.ServiceResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class CustomizedValidatorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        String errorMsg = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        Metadata metadata = new Metadata(HttpStatus.BAD_REQUEST.toString(), "Validation Failed",
                errorMsg);
        return new ResponseEntity(new ServiceResponse(metadata, null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest req) {
        String errorMsg = ex.getMessage();
        ex.printStackTrace();
        Metadata metadata = new Metadata(HttpStatus.BAD_REQUEST.toString(), "Validation Failed - Illegal Arguments",
                errorMsg);

        return new ResponseEntity<>(new ServiceResponse(metadata, null), HttpStatus.BAD_REQUEST);
    }

}