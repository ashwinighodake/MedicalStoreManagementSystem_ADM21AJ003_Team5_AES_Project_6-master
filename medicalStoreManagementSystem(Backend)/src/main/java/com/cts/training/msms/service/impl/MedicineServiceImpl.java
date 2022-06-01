package com.cts.training.msms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.training.msms.entity.Medicine;
import com.cts.training.msms.exception.ResourceNotFoundException;
import com.cts.training.msms.repository.MedicineRepository;
import com.cts.training.msms.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
		
	}

	@Override
	public Medicine saveMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
		
	}

	@Override
	public Medicine getMedicineById(Long id) {
		return medicineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicine doesn't exist with id: "+id));	
	}

	@Override
	public Medicine updateMedicine(Long id, Medicine medicineDetails) {
		Medicine medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicine doesn't exist with id: "+id));
		medicine.setName(medicineDetails.getName());
		medicine.setCompanyName(medicineDetails.getCompanyName());
		medicine.setQuantity(medicineDetails.getQuantity());
		medicine.setPrice(medicineDetails.getPrice());
		medicine.setExpiryDate(medicineDetails.getExpiryDate());
		Medicine updatedMedicine = medicineRepository.save(medicine);
		return updatedMedicine;
	}

	@Override
	public boolean deleteMedicine(Long id) {
		Medicine medicine = medicineRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Medicine doesn't exist with id: "+id));
		medicineRepository.delete(medicine);
		return true;
	}
	
	@Override
	public void getAfterOrder(Long id, Integer quantity) {
		medicineRepository.getQuantityAfterOrder(id, quantity);
		
	}

	@Override
	public List<Medicine> getOrdersToBePlaced() {
		return medicineRepository.findOrderTobePlaced();
	}
}
