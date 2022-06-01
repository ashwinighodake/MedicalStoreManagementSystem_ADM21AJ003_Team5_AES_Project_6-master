package com.cts.training.msms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.training.msms.controller.CustomerController;
import com.cts.training.msms.entity.Customer;
import com.cts.training.msms.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;
	
	@Test
	void testCreateCustomer() throws Exception {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		
		String inputInJson = this.mapToJson(customer);
		String URI = "/msms/v1/customers";
		
		Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn(customer);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	void testGetAllCustomers() throws Exception {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Customer customer1 = new Customer(2L, "Sasi", "NPT", "516433", "9807654321", "sasi@123", "sasi@123");
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer1);
		
		Mockito.when(customerService.getAllCustomers()).thenReturn(customers);
		
		String URI = "/msms/v1/customers";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(customers);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	void testGetCustomerById() throws Exception {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Mockito.when(customerService.getCustomerById(Mockito.anyLong())).thenReturn(customer);
		String URI = "/msms/v1/customers/1";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(customer);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	void testDeleteCustomer() throws Exception {
		Mockito.when(customerService.deleteCustomer(Mockito.anyLong())).thenReturn(true);
		String URI = "/msms/v1/customers/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Map<String , Boolean> response = new HashMap<>();
		response.put("Customer Deleted", true);
		String expectedJson = this.mapToJson(response);
		String output = result.getResponse().getContentAsString();
		assertEquals(expectedJson, output);
	}
	
	@Test
	void testUpdateCustomer() throws Exception {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		String inputInJson = this.mapToJson(customer);
		String URI = "/msms/v1/customers/1";
		
		Mockito.when(customerService.updateCustomer(Mockito.anyLong(), Mockito.any(Customer.class))).thenReturn(customer);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	void testGetCustomerByPhone() throws Exception {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Mockito.when(customerService.getCustomerByPhoneNumber(Mockito.anyString())).thenReturn(customer);
		String URI = "/msms/v1/customers/phone/9087654321";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(customer);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	void testGetCustomerByUserName() throws Exception {
		Customer customer = new Customer(1L, "Siva", "NPT", "516433", "9087654321", "siva@123", "siva@123");
		Mockito.when(customerService.getCustomerByUsername(Mockito.anyString())).thenReturn(customer);
		String URI = "/msms/v1/customers/username/siva@123";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(customer);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	//Maps an object into a JSON string. Use a Jackson ObjectMapper
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();			
		return objectMapper.writeValueAsString(object);
	}

}
