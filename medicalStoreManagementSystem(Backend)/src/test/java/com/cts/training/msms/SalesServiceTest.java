package com.cts.training.msms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.training.msms.entity.Customer;
import com.cts.training.msms.entity.Medicine;
import com.cts.training.msms.entity.Sales;
import com.cts.training.msms.repository.SalesRepository;
import com.cts.training.msms.service.SalesService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SalesServiceTest {
	
	@MockBean
	private SalesRepository salesRepository;
	
	@Autowired
	private SalesService salesService;
	
	@Test
	void testAddSale() {
		Sales sales = new Sales();
		sales.setId(1L);
		sales.setCustomer(new Customer(1L, "Siva Mohan Reddy", "Nawabpet", "516433", "9081234567", "Siva@123", "Siva@123"));
		sales.setMedicine(new Medicine(1L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021"));
		sales.setQuantity(10);
		sales.setAmount(100.0);
		sales.setDate("11/06/2021");
		Mockito.when(salesRepository.save(sales)).thenReturn(sales);
		assertEquals("Fever", sales.getMedicine().getCategory());
	}
	
	@Test
	void testGetSales() {
		List<Sales> sales = new ArrayList<>();
		Sales sale = new Sales(1L, new Customer(1L, "Siva", "Nawabpet", "516433", "9553603828", "Siva@123", "Siva@123"), new Medicine(1L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021"), 10, 100.0, "11/06/2021");
		sales.add(sale);
		Mockito.when(salesRepository.findAll()).thenReturn(sales);
		assertThat(salesService.getSales()).isEqualTo(sales);
	}
}
