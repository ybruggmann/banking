/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.rest;

import com.crealogix.apprentice.banking.util.exception.ObjectDoesNotExistException;
import com.crealogix.apprentice.banking.util.exception.ObjectNotCreatedException;
import com.crealogix.apprentice.banking.util.exception.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseEntityExceptionHandlerClx extends ResponseEntityExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(ResponseEntityExceptionHandlerClx.class);

  @ExceptionHandler(value = { ObjectDoesNotExistException.class })
  protected ResponseEntity<Object> handleObjectDoesNotExistException(ObjectDoesNotExistException e, WebRequest request) {
    logInfo(e);
    return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = { ObjectNotCreatedException.class })
  protected ResponseEntity<Object> handleObjectNotCreatedException(ObjectNotCreatedException e, WebRequest request) {
    logInfo(e);
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = { ValidationException.class })
  protected ResponseEntity<Object> handleValidationException(ValidationException e, WebRequest request) {
    logInfo(e);
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({ Exception.class })
  public ResponseEntity<Object> handleGenericException(Exception e, WebRequest request) {
    logInfo(e);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  protected void logInfo(Exception ex) {
    if (LOG.isDebugEnabled()) {
      LOG.error("[ResponseEntityExceptionHandlerClx] " + ex.getClass().getName() + ": " + ex.getMessage(), ex);
    } else {
      LOG.info("[ResponseEntityExceptionHandlerClx] " + ex.getClass().getName() + ": " + ex.getMessage());
    }
  }
}