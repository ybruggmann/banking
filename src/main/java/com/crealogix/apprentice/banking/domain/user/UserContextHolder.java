/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.domain.user;

public interface UserContextHolder {

  void setUserContext(UserContext userContext);

  UserContext getUserContext();
}