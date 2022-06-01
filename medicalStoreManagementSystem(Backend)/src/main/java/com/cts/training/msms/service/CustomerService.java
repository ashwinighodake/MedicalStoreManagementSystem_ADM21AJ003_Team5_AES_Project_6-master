package com.cts.training.msms.service;

import java.util.List;

import com.cts.training.msms.entity.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
	Customer saveCustomer(Customer customer);
	
	Customer getCustomerById(Long id);
	
	Customer updateCustomer(Long id, Customer customerDetails);
	
	boolean deleteCustomer(Long id);
	
	Customer getCustomerByPhoneNumber(String phone);

	Customer getCustomerByUsername(String username);
	
}
