/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.dto;

import java.util.Objects;

public class Person {

  private final Long id;

  private final String name;

  private final String firstName;

  public Person() {
    this(null, null, null);
  }

  public Person(Long id, String name, String firstName) {
    this.id = id;
    this.name = name;
    this.firstName = firstName;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getFirstName() {
    return firstName;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + ", firstName=" + firstName + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Person))
      return false;
    Person other = (Person) obj;
    return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
  }
}