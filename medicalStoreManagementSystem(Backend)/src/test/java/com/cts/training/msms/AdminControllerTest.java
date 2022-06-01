package com.cts.training.msms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.training.msms.controller.AdminController;
import com.cts.training.msms.entity.Admin;
import com.cts.training.msms.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class)
class AdminControllerTest {
	
	@Autowired(required = true)
	private MockMvc mockMvc;
	
	@MockBean
	private AdminService adminService;
	
	@Test
	void testGetAdminByUsername() throws Exception{
		Admin admin = new Admin(1L, "admin", "admin");
		
		Mockito.when(adminService.getAdminByUserName(admin.getUsername())).thenReturn(admin);
		String URI = "/msms/v1/admin/admin";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(admin);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	//Maps an object into a JSON string. Use a Jackson ObjectMapper
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}