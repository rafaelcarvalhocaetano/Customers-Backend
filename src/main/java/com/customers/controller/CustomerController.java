package com.customers.controller;

import java.util.Optional;

import com.customers.exceptions.CustomerException;
import com.customers.model.Customer;
import com.customers.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {


  @Autowired
  private CustomerService service;

  @GetMapping()
  public Iterable<Customer> getCustomer() {
    return service.findAllCustomers();
  }

  @GetMapping(value = "{id}")
  public Optional<Customer> getCustomerById(@PathVariable("id") String id) {
    try {
      return service.findCustomerId(id);
    } catch (CustomerException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @PostMapping()
  public Customer createCustomer(@RequestBody Customer customer) {
    try {
      return service.create(customer);
    } catch (CustomerException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }


  @PutMapping()
  public Customer updateCustomer(@RequestBody Customer customer) {
    try {
      return service.update(customer);
    } catch (CustomerException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }


  @DeleteMapping(value = "{id}")
  public void deleteCustomer(@PathVariable("id") String id) {
    service.delete(id);
  }
  
}