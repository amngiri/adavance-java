package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.UserHandlingException;
import com.app.dao.BankAccountRepository;
import com.app.dao.CustomerRepository;
import com.app.dto.CreateAccountRequest;
import com.app.dto.LoginResponse;
import com.app.pojos.BankAccount;
import com.app.pojos.Customer;


@Service
@Transactional
public class NetBankingServiceImpl implements INetBankingService {
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private BankAccountRepository acctRepo;

	@Override
	public LoginResponse authenticateCustomer(String customerId, String pwd) {
		Customer customer = custRepo.findByCustomerIdAndPassword(customerId, pwd)
				.orElseThrow(() -> new RuntimeException("Auth Failed"));
		return new LoginResponse(customer.getName(), acctRepo.findByAcctOwnerCustomerId(customer.getCustomerId()));
	}

	@Override
	public BankAccount createNewAccount(CreateAccountRequest request) {
		// get customer by it's id.
		Customer customer = custRepo.findById(request.getCustId())
				.orElseThrow(()->new UserHandlingException("Invalid customer ID!!!!!"));
		// create transient bank account instance
		BankAccount account=new BankAccount(request.getType(), request.getBalance());
		// establish uni dir link
		account.setAcctOwner(customer);
		// save
		return acctRepo.save(account);
	}//rets DETACHED account to the caller : since tx is over.

}
