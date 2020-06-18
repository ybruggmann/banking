/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.domain.service;

import com.crealogix.apprentice.banking.domain.api.CustomerDomainService;
import com.crealogix.apprentice.banking.dto.Customer;
import com.crealogix.apprentice.banking.persistence.entity.CustomerEntity;
import com.crealogix.apprentice.banking.persistence.repository.CustomerRepository;
import com.crealogix.apprentice.banking.util.exception.ObjectDoesNotExistException;
import com.crealogix.apprentice.banking.util.exception.ObjectNotCreatedException;
import com.crealogix.apprentice.banking.util.function.CustomerFunctions;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerDomainServiceImpl implements CustomerDomainService {

  private final CustomerRepository customerRepository;

  public CustomerDomainServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Customer getCustomerById(Long id) {
    Optional<CustomerEntity> customerEntityOpt = customerRepository.findById(id);
    return customerEntityOpt.map(CustomerFunctions.mapToDto).orElseThrow(() -> new ObjectDoesNotExistException());
  }

  @Override
  public void createCustomer(Customer customer) {
    CustomerFunctions.isValid(customer);
    customerRepository.save(Optional.of(customer).map(CustomerFunctions.mapToEntity).orElseThrow(() -> new ObjectNotCreatedException()));
  }
}