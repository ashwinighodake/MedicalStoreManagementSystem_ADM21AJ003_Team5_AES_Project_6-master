package com.cts.training.msms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.training.msms.entity.Medicine;
import com.cts.training.msms.repository.MedicineRepository;
import com.cts.training.msms.service.MedicineService;

@RunWith(SpringRunner.class)
@SpringBootTest
class MedicineServiceTest {
	
	@MockBean
	private MedicineRepository medicineRepository;
	
	@Autowired
	private MedicineService medicineService;
	
	@Test
	void testCreateMedicine() {
		Medicine medicine = new Medicine(1L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021");
		Mockito.when(medicineRepository.save(medicine)).thenReturn(medicine);
		assertThat(medicineService.saveMedicine(medicine)).isEqualTo(medicine);
	}
	
	@Test
	void testGetAllMedicine() {
		List<Medicine> medicines = new ArrayList<>();
		Medicine medicine = new Medicine(1L, "Covaxin", "BBio", 1000, 1250, "Covid", "22/10/2021");
		Medicine medicine2 = new Medicine(2L, "Cipladine", "Cipla", 100, 10, "Fever", "22/10/2021");
		medicines.add(medicine);
		medicines.add(medicine2);
		Mockito.when(medicineRepository.findAll()).thenReturn(medicines);
		List<Medicine> medicines2 = medicineService.getAllMedicines();
		assertEquals(2, medicines2.size());
		assertThat(medicineService.getAllMedicines()).isEqualTo(medicines);
	}
	
	@Test
	void testGetMedicineById() {
		Medicine medicine = new Medicine(1L, "Covaxin", "BBio", 1000, 1250, "Covid", "22/10/2021");
		Mockito.when(medicineRepository.findById(medicine.getId())).thenReturn(Optional.of(medicine));
		assertThat(medicineService.getMedicineById(1L)).isEqualTo(medicine);
	}
	
	@Test
	void testDeleteMedicine() {
		Medicine medicine = new Medicine(1L, "Covaxin", "BBio", 1000, 1250, "Covid", "22/10/2021");
		Mockito.when(medicineRepository.findById(1L)).thenReturn(Optional.of(medicine));
		Mockito.when(medicineRepository.existsById(medicine.getId())).thenReturn(false);
		assertFalse(medicineRepository.existsById(medicine.getId()));
	}
	
	@Test
	void testUpdateMedicine() {
		Medicine medicine = new Medicine(1L, "Covaxin", "BBio", 1000, 1250, "Covid", "22/10/2021");
		Mockito.when(medicineRepository.findById(medicine.getId())).thenReturn(Optional.of(medicine));
		medicine.setCompanyName("SII");
		Mockito.when(medicineRepository.save(medicine)).thenReturn(medicine);
		assertThat(medicineService.updateMedicine(medicine.getId(), medicine)).isEqualTo(medicine);
		assertEquals("SII", medicine.getCompanyName());
	}

}
