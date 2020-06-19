/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.rest;

import com.crealogix.apprentice.banking.domain.api.PersonDomainService;
import com.crealogix.apprentice.banking.domain.api.UserDomainService;
import com.crealogix.apprentice.banking.dto.Person;
import com.sun.istack.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RestControllerMappings.BANKING_REST + RestControllerMappings.PERSON_ENDPOINT)
public class PersonRestController extends BaseRestController {

  private final PersonDomainService personDomainService;

  public PersonRestController(UserDomainService userDomainService, PersonDomainService personDomainService) {
    super(userDomainService);
    this.personDomainService = personDomainService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> getPerson(@NotNull @RequestHeader("authorityId") Long authorityId) {
    authorizeCustomerRequest(authorityId);
    return new ResponseEntity<Person>(personDomainService.getPerson(), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> getCustomerById(@NotNull @RequestHeader("authorityId") Long authorityId, @NotNull @PathVariable("id") Long personId) {
    authorizeAdministratorRequest(authorityId);
    return new ResponseEntity<Person>(personDomainService.getPerson(personId), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> createPerson(@NotNull @RequestHeader("authorityId") Long authorityId, @RequestBody Person person) {
    authorizeAdministratorRequest(authorityId);
    personDomainService.createPerson(person);
    return new ResponseEntity<Object>("Person created.", HttpStatus.OK);
  }
}