package com.cts.training.msms.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
	private Customer customer;
	
	@ManyToOne(targetEntity = Medicine.class)
	@JoinColumn(name = "medicine_id",referencedColumnName ="medicine_id")
	private Medicine medicine;
	
	private Integer quantity;
	
	private Double amount;
	
	private String date;
	
	
	public Sales() {
		super();
	}
	
	public Sales(Long id, Customer customer, Medicine medicine, Integer quantity, Double amount, String date) {
		super();
		this.id = id;
		this.customer = customer;
		this.medicine = medicine;
		this.quantity = quantity;
		this.amount = amount;
		this.date = date;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}