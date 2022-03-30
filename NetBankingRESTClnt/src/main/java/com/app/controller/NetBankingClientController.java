package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequest;
import com.app.service.INetBankingClientService;

@RestController
@RequestMapping("/bank")
public class NetBankingClientController {
	@Autowired
	private INetBankingClientService clntService;

	public NetBankingClientController() {
		System.out.println("in ctor of " + getClass());
	}

	// add RESTful method to authenticate BankCustomer in netbanking app --> which
	// runs on a different web server)
	@PostMapping("/accts")
	public ResponseEntity<?> authenticateBankCustomer(@RequestBody LoginRequest request) {
		System.out.println("in auth : net banking clnt " + request);
		return clntService.authenticateBankCustomer(request);
	}

}
