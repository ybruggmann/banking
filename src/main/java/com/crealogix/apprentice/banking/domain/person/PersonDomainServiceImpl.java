/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.domain.person;

import com.crealogix.apprentice.banking.domain.api.PersonDomainService;
import com.crealogix.apprentice.banking.domain.user.UserContext;
import com.crealogix.apprentice.banking.domain.user.UserContextHolder;
import com.crealogix.apprentice.banking.dto.Person;
import com.crealogix.apprentice.banking.persistence.entity.PersonEntity;
import com.crealogix.apprentice.banking.persistence.repository.PersonRepository;
import com.crealogix.apprentice.banking.util.exception.ObjectDoesNotExistException;
import com.crealogix.apprentice.banking.util.exception.ObjectNotCreatedException;
import com.crealogix.apprentice.banking.util.function.PersonFunctions;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonDomainServiceImpl implements PersonDomainService {

  private final UserContextHolder userContextHolder;

  private final PersonRepository personRepository;

  public PersonDomainServiceImpl(UserContextHolder userContextHolder, PersonRepository personRepository) {
    this.userContextHolder = userContextHolder;
    this.personRepository = personRepository;
  }

  @Override
  public Person getPerson() {
    UserContext userContext = userContextHolder.getUserContext();
    return getPerson(userContext.getPersonId());
  }

  @Override
  public Person getPerson(Long personId) {
    Optional<PersonEntity> customerEntityOpt = personRepository.findById(personId);
    return customerEntityOpt.map(PersonFunctions.mapToDto).orElseThrow(() -> new ObjectDoesNotExistException("No person found for id " + personId + "."));
  }

  @Override
  public void createPerson(Person person) {
    PersonFunctions.isValid(person);
    personRepository
        .save(Optional.of(person).map(PersonFunctions.mapToEntity).orElseThrow(() -> new ObjectNotCreatedException("No able to save " + person + ".")));
  }
}