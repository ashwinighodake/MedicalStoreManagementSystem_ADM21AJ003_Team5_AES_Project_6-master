package com.cts.training.msms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.training.msms.entity.Customer;
import com.cts.training.msms.exception.ResourceNotFoundException;
import com.cts.training.msms.repository.CustomerRepository;
import com.cts.training.msms.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
			return customerRepository.save(customer);			
	}
		
	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer doesn't exist with id: "+id));
		
	}

	@Override
	public Customer updateCustomer(Long id, Customer customerDetails) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer doesn't exist with id: "+id));
		customer.setName(customerDetails.getName());
		customer.setVillage(customerDetails.getVillage());
		customer.setPincode(customerDetails.getPincode());
		customer.setPhone(customerDetails.getPhone());
		customer.setPassword(customerDetails.getPassword());
		Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
	}

	@Override
	public boolean deleteCustomer(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer doesn't exist with id: "+id));
		customerRepository.delete(customer);
		return true;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Customer customer = customerRepository.findByUsername(username);
		if(customer != null) {
			return customer;
		}
		else {
			throw new ResourceNotFoundException("Customer doesn't exist");
		}
	}

	@Override
	public Customer getCustomerByPhoneNumber(String phone) {
		return customerRepository.findByPhone(phone);
	}


	
}