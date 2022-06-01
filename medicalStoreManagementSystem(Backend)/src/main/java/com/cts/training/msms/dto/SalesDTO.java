package com.cts.training.msms.dto;

public class SalesDTO {
	
	private Long medicineId;
	private String customerPhone;
	private Integer quantity;
	
	public SalesDTO() {
		super();
	}
	
	public SalesDTO(Long medicineId, String customerPhone, Integer quantity) {
		super();
		this.medicineId = medicineId;
		this.customerPhone = customerPhone;
		this.quantity = quantity;
	}

	public Long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Override
	public String toString() {
		return "SalesDTO [medicineId=" + medicineId + ", customerPhone=" + customerPhone + ", quantity=" + quantity
				+ "]";
	}
	
	

}
