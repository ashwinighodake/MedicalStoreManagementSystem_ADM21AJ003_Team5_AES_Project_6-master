package com.cts.training.msms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.training.msms.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public Customer findByName(String name);
	
	public Customer findByUsernameAndPassword(String username, String password);
	
	public Customer findByPhone(String phone);

	public Customer findByUsername(String username);

}
