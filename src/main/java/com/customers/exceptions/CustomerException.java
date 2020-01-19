package com.customers.exceptions;


public class CustomerException extends Exception {

  private static final long serialVersionUID = 1L;
  
  public CustomerException(String error) {
    super(error);
  }
  
}