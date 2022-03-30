package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// no specific dependency!

	public ATMImpl(Transport t12345) {
		myTransport=t12345;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);//not null
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
	public void customInit() {
		System.out.println("in init " + myTransport);// not null => custom init method gets called by SC AFTER D.I
	}

	public void customDestroy() {
		System.out.println("in destroy " + myTransport);// not null => custom destroy method gets called by SC , only
														// for singleton scoped beans ,
		// just before the GC of beanns , triggered by shutting down the SC

	}

}
