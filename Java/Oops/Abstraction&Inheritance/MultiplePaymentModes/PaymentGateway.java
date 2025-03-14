
public interface PaymentGateway {
	
    void processPayment(double amount);

    boolean validatePayment();

}

