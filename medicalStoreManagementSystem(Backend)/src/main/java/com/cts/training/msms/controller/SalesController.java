package com.cts.training.msms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.msms.dto.SalesDTO;
import com.cts.training.msms.entity.Sales;
import com.cts.training.msms.service.SalesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/msms/v1")
public class SalesController {
	
	private static final Logger LOGGER = LogManager.getLogger(SalesController.class);
	
	@Autowired
	private SalesService salesService;
	
	@PostMapping("/sales")
	public ResponseEntity<Sales> addSales(@RequestBody SalesDTO salesDTO){
		LOGGER.info("Inside add sales method of sales controller");
		Sales sale = salesService.addSale(salesDTO);
		return ResponseEntity.ok(sale);	
	}
	
	@GetMapping("/sales")
	public List<Sales> getAllSales(){
		LOGGER.info("Inside get all sales method of sales controller");
		List<Sales> sales = salesService.getSales();
		return sales;
	}
	
	@GetMapping("/sales/{date}")
	public List<Sales> getDailySales(@PathVariable String date){
		LOGGER.info("Inside get daily sales method of sales controller");
		return salesService.getDailySales(date);		
	}
}
