package com.cts.training.msms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.msms.entity.Medicine;
import com.cts.training.msms.service.MedicineService;

@CrossOrigin("*")
@RestController
@RequestMapping("/msms/v1")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	private static final Logger LOGGER = LogManager.getLogger(MedicineController.class);
	
	//Get list of medicines
	@GetMapping("/medicines")
	public List<Medicine> getMedicine(){
		LOGGER.info("Inside get all medicines method medicine controller");
		return medicineService.getAllMedicines();
	}
	
	//Add a medicine
	@PostMapping("/medicines")
	public Medicine createMedicine(@Valid @RequestBody Medicine medicine) {
		LOGGER.info("Inside create medicine method medicine controller");
		return medicineService.saveMedicine(medicine);		
	}
	
	//Get a medicine by id
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
		LOGGER.info("Inside get medicine by id method medicine controller");
		Medicine medicine = medicineService.getMedicineById(id);
		return ResponseEntity.ok(medicine);
	}
	
	//Update medicine
	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine> updateMedicineById(@Valid @PathVariable Long id, @RequestBody Medicine medicine){
		LOGGER.info("Inside update medicine by id method medicine controller");
		Medicine updatedMedicine = medicineService.updateMedicine(id, medicine);
		return ResponseEntity.ok(updatedMedicine);
	}
	
	//Delete Medicine
	@DeleteMapping("medicines/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteMedicineById(@PathVariable Long id){
		LOGGER.info("Inside delete medicine by id method medicine controller");
		medicineService.deleteMedicine(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Medicine deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);		
	}	
	
	//Order To Be Placed 
	@GetMapping("/medicines/order")
	public List<Medicine> getOrderTobePlaced(){
		LOGGER.info("Inside get Orders of medicine to be placed method medicine controller");
		return medicineService.getOrdersToBePlaced();
		
	}
		
}
