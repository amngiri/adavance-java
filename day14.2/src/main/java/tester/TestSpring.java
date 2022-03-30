package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean-config.xml"))
		{
			System.out.println("SC strted....");
			//invoke B.L : deposit funds
			//get already located--loaded--instantiated --setter based D.I --inited --ready to use spring bean(atm) from SC
			//o.s.b.f.BeanFactory : method
			//public <T> T getBean(String beanId/name , Class<T> cls) throws BeansException : un chked exc
			ATMImpl ref1=ctx.getBean("my_atm", ATMImpl.class);//1st demand
			//B.L
			ref1.deposit(12345);
			ATMImpl ref2=ctx.getBean("my_atm", ATMImpl.class);//2nd demand
			System.out.println(ref1==ref2);
		}// ctx.close => SC shutdown
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
