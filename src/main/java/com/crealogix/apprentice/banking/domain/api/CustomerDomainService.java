/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.domain.api;

import com.crealogix.apprentice.banking.dto.Customer;

public interface CustomerDomainService {

  Customer getCustomerById(Long id);

  void createCustomer(Customer customer);
}