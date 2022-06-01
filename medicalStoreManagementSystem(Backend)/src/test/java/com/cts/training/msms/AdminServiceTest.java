
package com.cts.training.msms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.training.msms.entity.Admin;
import com.cts.training.msms.repository.AdminRepository;
import com.cts.training.msms.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {
	
	@MockBean
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminService adminService;
	
	@Test
	void testGetAdminByUsername() {
		Admin admin = new Admin(1L, "admin", "admin");
		Mockito.when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);
		assertThat(adminService.getAdminByUserName(admin.getUsername())).isEqualTo(admin);
	}
		
	}