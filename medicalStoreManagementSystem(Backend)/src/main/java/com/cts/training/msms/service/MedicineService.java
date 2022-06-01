package com.cts.training.msms.service;

import java.util.List;

import com.cts.training.msms.entity.Medicine;

public interface MedicineService {
	
	List<Medicine> getAllMedicines();
	
	Medicine saveMedicine(Medicine medicine);
	
	Medicine getMedicineById(Long id);
	
	Medicine updateMedicine(Long id, Medicine medicineDetails);
	
	boolean deleteMedicine(Long id);
	
	void getAfterOrder(Long id, Integer quantity);

	List<Medicine> getOrdersToBePlaced();

}
