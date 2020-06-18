/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.util.function;

import com.crealogix.apprentice.banking.dto.Customer;
import com.crealogix.apprentice.banking.persistence.entity.CustomerEntity;
import com.crealogix.apprentice.banking.util.exception.ValidationException;

import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

public interface CustomerFunctions {

  Function<CustomerEntity, Customer> mapToDto = ce -> new Customer(//
      ce.getId(), //
      ce.getFirstName(), //
      ce.getName()//
  );

  Function<Customer, CustomerEntity> mapToEntity = c -> new CustomerEntity(//
      c.getFirstName(), //
      c.getName()//
  );

  static void isValid(Customer customer) {
    if (customer.getId() != null || StringUtils.isBlank(customer.getFirstName()) || StringUtils.isBlank(customer.getName())) {
      throw new ValidationException();
    }
  }
}