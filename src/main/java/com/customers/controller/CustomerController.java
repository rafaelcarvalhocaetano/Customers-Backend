package com.customers.controller;

import com.customers.model.Customer;
import com.customers.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {


  @Autowired
  private CustomerService service;

  @GetMapping()
  public Iterable<Customer> getCustomer() {
    return service.findAllCustomers();
  }
  
}