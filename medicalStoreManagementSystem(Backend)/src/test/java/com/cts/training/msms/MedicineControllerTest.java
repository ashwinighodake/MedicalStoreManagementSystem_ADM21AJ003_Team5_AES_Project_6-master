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

import com.cts.training.msms.controller.MedicineController;
import com.cts.training.msms.entity.Medicine;
import com.cts.training.msms.service.MedicineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MedicineController.class)
class MedicineControllerTest {
	
	@Autowired(required = true)
	private MockMvc mockMvc;
	
	@MockBean
	private MedicineService medicineService;
	
	@Test
	void testCreateMedicine() throws Exception {
		Medicine medicine = new Medicine(1L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021");
		String inputInJson = this.mapToJson(medicine);
		String URI = "/msms/v1/medicines";
		
		Mockito.when(medicineService.saveMedicine(Mockito.any(Medicine.class))).thenReturn(medicine);
		
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
		Medicine medicine = new Medicine(1L, "Covaxin", "BBio", 1000, 1250, "Covid", "22/10/2021");
		Medicine medicine2 = new Medicine(2L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021");
		List<Medicine> medicines = new ArrayList<>();
		medicines.add(medicine);
		medicines.add(medicine2);
		
		Mockito.when(medicineService.getAllMedicines()).thenReturn(medicines);
		
		String URI = "/msms/v1/medicines";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(medicines);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	void testGetMedicineById() throws Exception{
		Medicine medicine = new Medicine(1L, "Covaxin", "BBio", 1000, 1250, "Covid", "22/10/2021");
		
		Mockito.when(medicineService.getMedicineById(Mockito.anyLong())).thenReturn(medicine);
		String URI = "/msms/v1/medicines/1";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(medicine);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	void testDeleteMedicine() throws Exception {
		Mockito.when(medicineService.deleteMedicine(Mockito.anyLong())).thenReturn(true);
		String URI = "/msms/v1/medicines/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Map<String , Boolean> response = new HashMap<>();
		response.put("Medicine deleted", true);
		String expectedJson = this.mapToJson(response);
		String output = result.getResponse().getContentAsString();
		assertEquals(expectedJson, output);
	}
	
	@Test
	void testUpdateMedicine() throws Exception {
		Medicine medicine = new Medicine(1L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021");
		String inputInJson = this.mapToJson(medicine);
		String URI = "/msms/v1/medicines/1";
		
		Mockito.when(medicineService.updateMedicine(Mockito.anyLong(), Mockito.any(Medicine.class))).thenReturn(medicine);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	//Maps an object into a JSON string. Use a Jackson ObjectMapper
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
