package com.cts.training.msms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.msms.entity.Customer;
import com.cts.training.msms.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/msms/v1")
public class CustomerController {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	//Get list of customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		LOGGER.info("Inside get all customers method of customer controller");
		return customerService.getAllCustomers();	}
	
	//Create a customer
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		LOGGER.info("Inside create customer method of customer controller");
		Customer saveCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.ok(saveCustomer);
	}
	
	
	//Get a customer by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		LOGGER.info("Inside get customer by id method of customer controller");
		Customer customer = customerService.getCustomerById(id);
		return ResponseEntity.ok(customer);		
	}
	
	//Update a customer by id
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomerById(@Valid @PathVariable Long id, @RequestBody Customer customer){
		LOGGER.info("Inside update customer by id method of customer controller");
		Customer updateCustomer = customerService.updateCustomer(id, customer);	
		return ResponseEntity.ok(updateCustomer);
	}
	
	//Delete a customer by id
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomerById(@PathVariable Long id){
		LOGGER.info("Inside delete customer by id method of customer controller");
		customerService.deleteCustomer(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Customer Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	//Get a customer by name
	@GetMapping("/customers/username/{username}")
	public Customer getCustomerByName(@PathVariable String username) {
		LOGGER.info("Inside get customer name of customer controller");
		return customerService.getCustomerByUsername(username);
		
	}
	
	@GetMapping("/customers/phone/{phone}")
	public Customer getCustomerByPhone(@PathVariable String phone) {
		LOGGER.info("Inside get customer by phone method of customer controller");
		return customerService.getCustomerByPhoneNumber(phone);
	}
}	
