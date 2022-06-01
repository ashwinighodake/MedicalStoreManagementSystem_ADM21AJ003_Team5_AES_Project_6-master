package com.cts.training.msms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Medicine")
public class Medicine implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_id", updatable = false)
	private Long id;
	
	@Column(name = "medicine_name", nullable = false)
	@NotEmpty(message = "Medicine name cannot be empty")
	private String name;
	
	@Column(name = "company_name", nullable = false)
	@NotEmpty(message = "Medicine company name cannot be empty")
	private String companyName;
	
	@Column(name = "quantity", nullable = false)
	@NotNull(message = "Qunatity of Medicine cannot be null")
	private Integer quantity;
	
	@Column(name = "price_per_unit", nullable = false)
	@NotNull(message = "Price of Medicine cannot be null")
	private double price;
	
	@Column(name = "category", nullable = false)
	@NotEmpty(message = "Medicine category cannot be empty")
	private String category;
	
	@Column(name = "expiry_date", nullable = false)
	@NotEmpty(message = "Medicine expiry date cannot be empty")
	private String expiryDate;
	
	@OneToMany(targetEntity = Sales.class, mappedBy = "medicine")
	private List<Sales> sales;
	
	public Medicine() {
		super();
	}

	
	public Medicine(Long id,String name, String companyName, Integer quantity, Integer price, String category, String expiryDate) {
		super();
		this.id= id;
		this.name = name;
		this.companyName = companyName;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.expiryDate = expiryDate;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
