package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//Map this to existing tables "users"
@Table(name = "users")
public class User extends BaseEntity {

	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private UserRole role;

	public User() {
		
	}

	public User(String email, String password, LocalDate dob, String role) {
		super();
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.role = UserRole.valueOf(role.toUpperCase());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role =  UserRole.valueOf(role.toUpperCase());;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", dob=" + dob + ", role=" + role + "]";
	}
	

}
