/**
 *  Copyright (c) 2020 by CREALOGIX AG. All rights reserved.
 */
package com.crealogix.apprentice.banking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "login" }) })
@SequenceGenerator(name = BaseEntity.GENERATOR_NAME, sequenceName = "seq_user_id", initialValue = 1000)
public class UserEntity extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "login")
  private String login;

  @Column(name = "administrator")
  private boolean administrator;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id", nullable = false)
  private PersonEntity person;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public boolean isAdministrator() {
    return administrator;
  }

  public void setAdministrator(boolean administrator) {
    this.administrator = administrator;
  }

  public PersonEntity getPerson() {
    return person;
  }

  public void setPerson(PersonEntity person) {
    this.person = person;
  }

  @Override
  public String toString() {
    return "UserEntity [login=" + login + ", administrator=" + administrator + "]";
  }

  @Override
  public boolean equals(Object obj) {
    // Use only the id for the equals() implementation.
    // Also, when the entity id is null, we can guarantee equality only for the same object references. Otherwise, no transient object is equal to any
    // other transient or persisted object. That’s why the id equality check is done only if the current Object id is not null.
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof UserEntity)) {
      return false;
    }
    UserEntity other = (UserEntity) obj;
    return getId() != null && getId().equals(other.getId());
  }

  @Override
  public int hashCode() {
    // Fix value, because entity can exist with an id and without an id (new/transient).
    return 31;
  }
}