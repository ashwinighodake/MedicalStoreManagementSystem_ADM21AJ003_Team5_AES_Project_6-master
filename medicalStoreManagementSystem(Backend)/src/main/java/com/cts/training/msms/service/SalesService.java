package com.cts.training.msms.service;

import java.util.List;

import com.cts.training.msms.dto.SalesDTO;
import com.cts.training.msms.entity.Sales;

public interface SalesService {
	
	public Sales addSale(SalesDTO salesDTO);

	public List<Sales> getSales();

	public List<Sales> getDailySales(String date);

}
