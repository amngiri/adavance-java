package com.app.dto;



import com.app.pojos.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BankAccount extends BaseEntity {

	
	private AcctType acctType;
	private double balance;	
	@JsonIgnore // to tell Jackson(=vendor for marshalling n un marshalling) , to ignore this
				// property during ser n de-ser
	
	private Customer acctOwner;

	public BankAccount(AcctType acctType, double balance) {
		super();
		this.acctType = acctType;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [acctType=" + acctType + ", balance=" + balance + "]";
	}

}
