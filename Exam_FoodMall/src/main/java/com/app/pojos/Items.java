package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Items extends BaseEntity
{
	@Column(name="name")
	private String item1;
	private String item2;
	private String item3;
	
	public Items() {
		// TODO Auto-generated constructor stub
	}

	public Items(String item1, String item2, String item3) {
		super();
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	@Override
	public String toString() {
		return "Items [item1=" + item1 + ", item2=" + item2 + ", item3=" + item3 + "]";
	}

	
	
	
}
