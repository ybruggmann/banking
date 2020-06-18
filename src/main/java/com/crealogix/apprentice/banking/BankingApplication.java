/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"com.crealogix.apprentice.banking.persistence.repository"})
@EntityScan("com.crealogix.apprentice.banking.persistence.entity")
public class BankingApplication {

  public static void main(String[] args) {
    SpringApplication.run(BankingApplication.class, args);
  }
}