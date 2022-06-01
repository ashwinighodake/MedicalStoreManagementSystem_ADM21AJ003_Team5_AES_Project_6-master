package com.cts.training.msms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.training.msms.entity.Admin;
import com.cts.training.msms.exception.ResourceNotFoundException;
import com.cts.training.msms.repository.AdminRepository;
import com.cts.training.msms.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;


	@Override
	public Admin getAdminByUserName(String username) {
		Admin admin = adminRepository.findByUsername(username);
		if(admin != null) {
			return admin;
		}
		else {
			throw new ResourceNotFoundException("Admin not found with username: "+username);
		}
	}

}
