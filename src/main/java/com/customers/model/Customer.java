package com.customers.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

  private String id;
  private String name;
  private String firstName;
  private String phone;
  private String email;
  private String user;
  
  public Customer() { }

  public Customer(String name, String firstName, String phone, String email, String user) {
    this.name = name;
    this.firstName = firstName;
    this.phone = phone;
    this.email = email;
    this.user = user;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Customer other = (Customer) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Customer [email=" + email + ", firstName=" + firstName + ", id=" + id + ", name=" + name + ", phone="
        + phone + ", user=" + user + "]";
  }

  
}