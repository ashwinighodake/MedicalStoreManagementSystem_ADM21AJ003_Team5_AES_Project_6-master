package com.cts.training.msms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

import com.cts.training.msms.controller.SalesController;
import com.cts.training.msms.dto.SalesDTO;
import com.cts.training.msms.entity.Customer;
import com.cts.training.msms.entity.Medicine;
import com.cts.training.msms.entity.Sales;
import com.cts.training.msms.service.SalesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SalesController.class)
class SalesControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SalesService salesService;

	@Test
	void testAddSale() throws Exception {
		Sales sales = new Sales(1L, new Customer(1L, "Siva Mohan Reddy", "Nawabpet", "516433", "9081234567", "Siva@123", "Siva@123"), new Medicine(1L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021"), 100, 10.0, "22/10/2021");
		String inputInJson = this.mapToJson(sales);
		String URI = "/msms/v1/sales";
		
		Mockito.when(salesService.addSale(Mockito.any(SalesDTO.class))).thenReturn(sales);
		
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
	void testGetAllMedicines() throws Exception {
		List<Sales> sales = new ArrayList<>();
		Sales sale = new Sales(1L, new Customer(1L, "Siva", "Nawabpet", "516433", "9553603828", "Siva@123", "Siva@123"), new Medicine(1L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021"), 100, 10.0, "11/06/2021");
		sales.add(sale);
		
		Mockito.when(salesService.getSales()).thenReturn(sales);
		
		String URI = "/msms/v1/sales";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(sales);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	//Maps an object into a JSON string. Use a Jackson ObjectMapper
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
