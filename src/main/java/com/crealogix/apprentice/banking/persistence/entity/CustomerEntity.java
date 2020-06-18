/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", uniqueConstraints = { @UniqueConstraint(columnNames = { "first_name", "name" }) })
@SequenceGenerator(name = BaseEntity.GENERATOR_NAME, sequenceName = "seq_customer_id", initialValue = 1000)
public class CustomerEntity extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "name")
  private String name;

  public CustomerEntity() {
    // Needed by Hibernate
  }

  public CustomerEntity(String firstName, String name) {
    this.firstName = firstName;
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    // Use only the id for the equals() implementation.
    // Also, when the entity id is null, we can guarantee equality only for the same object references. Otherwise, no transient object is equal to any
    // other transient or persisted object. That’s why the id equality check is done only if the current Object id is not null.
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof CustomerEntity)) {
      return false;
    }
    CustomerEntity other = (CustomerEntity) obj;
    return getId() != null && getId().equals(other.getId());
  }

  @Override
  public int hashCode() {
    // Fix value, because entity can exist with an id and without an id (new/transient).
    return 31;
  }
}