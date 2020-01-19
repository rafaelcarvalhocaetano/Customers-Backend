package com.customers.service;

import com.customers.model.Customer;
import com.customers.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository repository;


  public Iterable<Customer> findAllCustomers() {
    return repository.findAll();
  }

  
}