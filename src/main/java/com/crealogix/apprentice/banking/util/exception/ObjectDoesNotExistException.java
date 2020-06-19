/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.util.exception;

public class ObjectDoesNotExistException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ObjectDoesNotExistException(String message) {
    super(message);
  }
}