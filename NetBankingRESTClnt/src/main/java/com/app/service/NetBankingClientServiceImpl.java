package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.dto.LoginRequest;
import com.app.dto.LoginResponse;

@Service
public class NetBankingClientServiceImpl implements INetBankingClientService {
	//SpEL : spring expression language
	@Value("${AUTH_URL}")
	private String authenticationURL;
	
	private RestTemplate template;
	//constr based D.I
	@Autowired //autowire=constructor
	//RestTemplateBuilder : rdy made bean supplied by spring boot frmwork
	//RestTemplate : built by prog using it's builder.
	public NetBankingClientServiceImpl(RestTemplateBuilder builder) {
		//create RestTemplate from it's builder
		template=builder.build();
	}

	@Override
	public ResponseEntity<LoginResponse> authenticateBankCustomer(LoginRequest request) {
		// Use RestTemplate API
		//ResponseEntity<T> postForEntity(String url,Object request , Class<T> responseTypeClass,Object... uriVars)
		System.out.println("auth url "+authenticationURL);
		ResponseEntity<LoginResponse> resp = template.postForEntity(authenticationURL, request, LoginResponse.class);		
		return resp;
	}

}
