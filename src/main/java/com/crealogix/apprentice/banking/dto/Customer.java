/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.dto;

import java.util.Objects;

public class Customer {

  private final Long id;

  private final String firstName;

  private final String name;

  public Customer() {
    this(null, null, null);
  }

  public Customer(Long id, String firstName, String name) {
    this.id = id;
    this.firstName = firstName;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", firstName=" + firstName + ", name=" + name + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Customer))
      return false;
    Customer other = (Customer) obj;
    return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
  }
}