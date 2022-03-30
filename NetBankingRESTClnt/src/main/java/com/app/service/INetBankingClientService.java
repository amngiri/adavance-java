package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.dto.LoginRequest;
import com.app.dto.LoginResponse;

public interface INetBankingClientService {

	ResponseEntity<LoginResponse> authenticateBankCustomer(LoginRequest request);

}
