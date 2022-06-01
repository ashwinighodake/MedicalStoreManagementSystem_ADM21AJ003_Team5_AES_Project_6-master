package com.cts.training.msms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.training.msms.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	Admin findByUsernameAndPassword(String username, String password);

	Admin findByUsername(String username);

}
