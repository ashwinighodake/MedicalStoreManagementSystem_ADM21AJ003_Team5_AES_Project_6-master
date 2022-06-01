package com.cts.training.msms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.msms.entity.Admin;
import com.cts.training.msms.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/msms/v1")
public class AdminController {

	private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin/{username}")
	public Admin getAdminByUserName(@PathVariable String username) {
		LOGGER.info("Inside get admin by username method of admin controller");
		return adminService.getAdminByUserName(username);
	}

}
