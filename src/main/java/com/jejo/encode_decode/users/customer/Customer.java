package com.jejo.encode_decode.users.customer;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long    id;

  @Basic
  private String  name;
  private String  lastname;
  private String  email;

  @OneToOne
  @JoinColumn(name = "user_id")
  private Users   user;

  public Customer() {
  }

  public Customer(Long id, String name, String lastname, String email, Users user) {
    this.id =       id;
    this.name =     name;
    this.lastname = lastname;
    this.email =    email;
    this.user =     user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
  }

  
}
