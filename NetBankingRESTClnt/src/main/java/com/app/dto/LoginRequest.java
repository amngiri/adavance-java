package com.app.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {
	@NotEmpty(message="customer id canot be blank")
	private String customerId;
	@NotEmpty(message="password cant be blank")
	private String password;
}
