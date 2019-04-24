package com.shomari.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

  // add handler for CustomerNotFoundException
  @ExceptionHandler
  public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e){

    // create customer error response
    CustomerErrorResponse customerErrorResponse =
        new CustomerErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());

    // return customer error response with appropriate status code
    return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);

  }

  // add handler for generic exception
  // add handler for CustomerNotFoundException
  @ExceptionHandler
  public ResponseEntity<CustomerErrorResponse> handleGenericException(Exception e){
    // create customer error response
    CustomerErrorResponse customerErrorResponse =
        new CustomerErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());

    // return customer error response with appropriate status code
    return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
  }

}
