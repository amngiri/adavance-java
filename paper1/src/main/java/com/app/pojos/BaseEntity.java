package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
public BaseEntity() {
	// TODO Auto-generated constructor stub
}
	public BaseEntity(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "BaseEntity [id=" + id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
