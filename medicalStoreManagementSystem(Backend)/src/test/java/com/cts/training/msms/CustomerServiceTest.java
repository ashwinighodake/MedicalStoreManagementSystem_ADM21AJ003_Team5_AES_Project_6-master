package com.cts.training.msms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.training.msms.entity.Customer;
import com.cts.training.msms.repository.CustomerRepository;
import com.cts.training.msms.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@Test
	void testCreateCustomer() {
		
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.saveCustomer(customer)).isEqualTo(customer);
	}
	
	@Test
	void testGetAllCustomers() {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Customer customer1 = new Customer(2L, "Sasi", "NPT", "516433", "9807654321", "sasi@123", "sasi@123");
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer1);
		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		assertThat(customerService.getAllCustomers()).isEqualTo(customers);
	}
	
	@Test
	void testGetCustomerById() {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Mockito.when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
		assertThat(customerService.getCustomerById(1L)).isEqualTo(customer);
	}
	
	@Test
	void testGetCustomerByUsername() {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Mockito.when(customerRepository.findByUsername(customer.getUsername())).thenReturn(customer);
		assertThat(customerService.getCustomerByUsername("siva@123")).isEqualTo(customer);
	}
	
	@Test
	void testDeleteCustomer() {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Mockito.when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
		Mockito.when(customerRepository.existsById(customer.getId())).thenReturn(false);
		assertFalse(customerRepository.existsById(customer.getId()));
	}
	
	@Test
	void testUpdateCustomer() {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Mockito.when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
		customer.setVillage("JMD");
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.updateCustomer(customer.getId(), customer)).isEqualTo(customer);
		assertEquals("JMD", customer.getVillage());
	}
	
}
