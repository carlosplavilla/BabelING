package com.igarridos.babel.ing.test.paymentTest;

public interface PaymentStrategy {

	public static final double serviceCharge = 5.00;
	public static final double creditCardFee = 10.00;
	
	
	public static double cashPayment(double amount) {
		return serviceCharge + amount;
	}
	
	public static double cardPayment(double amount) {
		return serviceCharge + creditCardFee + amount;
	}
}
