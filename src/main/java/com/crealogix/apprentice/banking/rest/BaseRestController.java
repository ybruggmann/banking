/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.rest;

import com.crealogix.apprentice.banking.domain.api.UserDomainService;

public abstract class BaseRestController {

  private final UserDomainService userDomainService;

  public BaseRestController(UserDomainService userDomainService) {
    this.userDomainService = userDomainService;
  }

  protected void authorizeAdministratorRequest(Long authorityId) {
    userDomainService.authorizeAdministratorRequest(authorityId);
  }

  protected void authorizeCustomerRequest(Long authorityId) {
    userDomainService.authorizeCustomerRequest(authorityId);
  }
}