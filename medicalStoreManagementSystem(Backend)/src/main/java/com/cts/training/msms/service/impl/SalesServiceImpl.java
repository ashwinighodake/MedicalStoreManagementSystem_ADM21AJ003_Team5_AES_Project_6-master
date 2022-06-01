package com.cts.training.msms.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.training.msms.dto.SalesDTO;
import com.cts.training.msms.entity.Customer;
import com.cts.training.msms.entity.Medicine;
import com.cts.training.msms.entity.Sales;
import com.cts.training.msms.exception.ResourceNotFoundException;
import com.cts.training.msms.repository.CustomerRepository;
import com.cts.training.msms.repository.MedicineRepository;
import com.cts.training.msms.repository.SalesRepository;
import com.cts.training.msms.service.MedicineService;
import com.cts.training.msms.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	private SalesRepository salesRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Autowired
	private MedicineService medicineService;
		
	@Override
	public Sales addSale(SalesDTO salesDTO) {
		Sales sales = new Sales();
		LocalDate today = LocalDate.now();		 
		String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Medicine medicine = medicineService.getMedicineById(salesDTO.getMedicineId());
		Customer customer = customerRepository.findByPhone(salesDTO.getCustomerPhone());
		if(medicine.getQuantity()<salesDTO.getQuantity()) {
			throw new ResourceNotFoundException("Required quantity Not available");
		}else if(customer!=null) {
		sales.setMedicine(medicine);
		sales.setCustomer(customer);
		sales.setQuantity(salesDTO.getQuantity());
		sales.setAmount(((double)salesDTO.getQuantity() * medicine.getPrice()));
		sales.setDate(formattedDate);
		Sales saveSales = salesRepository.save(sales);
		medicineRepository.getQuantityAfterOrder(medicine.getId(), salesDTO.getQuantity());
		return saveSales;
		}
		else {
			throw new ResourceNotFoundException("Customer Phone Number Not available");
		}
	}

	@Override
	public List<Sales> getSales() {
		List<Sales> salesList = salesRepository.findAll();
		return salesList;
	}

	@Override
	public List<Sales> getDailySales(String date) {
		return salesRepository.getDailySales(date);
	}

}
