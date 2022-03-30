package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import dependency.Transport;

//prototype
@Component("my_atm")
@Scope("prototype")
public class ATMImpl implements ATM {
	@Autowired //autowire="byType"	
	@Qualifier("httpTransport") //autowire="byName"
	private Transport myTransport;

	public ATMImpl() {

		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling the method of dependency : for informing the
										// underlying bank

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling the method of dependency : for informing the
		// underlying bank
	}

	

	// life cycle hooks(=methods)
	@PostConstruct
	public void customInit() {
		System.out.println("in init " + myTransport);// not null => custom init method gets called by SC AFTER D.I
	}
	@PreDestroy
	public void customDestroy() {
		System.out.println("in destroy " + myTransport);// not null => custom destroy method gets called by SC , only
														// for singleton scoped beans ,
		// just before the GC of beanns , triggered by shutting down the SC

	}

}
