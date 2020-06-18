/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.rest;

import com.crealogix.apprentice.banking.domain.api.CustomerDomainService;
import com.crealogix.apprentice.banking.dto.Customer;
import com.sun.istack.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RestControllerMappings.BANKING_REST + RestControllerMappings.CUSTOMER_ENDPOINT)
public class CustomerRestController {

  private final CustomerDomainService customerDomainService;

  public CustomerRestController(CustomerDomainService customerDomainService) {
    this.customerDomainService = customerDomainService;
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Customer> getCustomerById(@NotNull @PathVariable("id") Long customerId) {
    return new ResponseEntity<Customer>(customerDomainService.getCustomerById(customerId), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
    customerDomainService.createCustomer(customer);
    return new ResponseEntity<Object>("Customer created.", HttpStatus.OK);
  }
}