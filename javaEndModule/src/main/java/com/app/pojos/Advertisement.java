package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "advertisement")
public class Advertisement extends BaseEntity {
	private String product;
	private String brand;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate telecastDate;
	private String status;
	
	public Advertisement() {
		// TODO Auto-generated constructor stub
	}
	
	public Advertisement(String product, String brand, LocalDate telecastDate, String status) {
		super();
		this.product = product;
		this.brand = brand;
		this.telecastDate = telecastDate;
		this.status = status;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public LocalDate getTelecastDate() {
		return telecastDate;
	}
	public void setTelecastDate(LocalDate telecastDate) {
		this.telecastDate = telecastDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
