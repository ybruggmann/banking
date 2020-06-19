/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.domain.api;

import com.crealogix.apprentice.banking.dto.Person;

public interface PersonDomainService {

  Person getPerson();

  Person getPerson(Long personId);

  void createPerson(Person person);
}