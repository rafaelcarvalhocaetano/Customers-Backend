package com.customers.service;

import java.util.Optional;

import com.customers.exceptions.CustomerException;
import com.customers.model.Customer;
import com.customers.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository repository;


  public Iterable<Customer> findAllCustomers() {
    return repository.findAll();
  }

  public Optional<Customer> findCustomerId(String id) throws CustomerException {
    Optional<Customer> customer = repository.findById(id);
    if (!customer.isPresent()) {
      throw new CustomerException("Not Found ID CUSTOMER");
    }
    return customer;
  }

  public Customer create(Customer customer) throws CustomerException {
    return repository.save(customer);
	}
	
	public Customer update(Customer customer) throws CustomerException {
		Optional<Customer> cOptional = repository.findById(customer.getId());
		if (!cOptional.isPresent()) {
			throw new CustomerException("Customer not found in Customer Repository");
		}
		return repository.save(customer);
	}

	public void delete(String id) {
		Optional<Customer> customer = repository.findById(id);
		if (!customer.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error deleting Customer");
		} 
		repository.deleteById(id);		
	}

  
}