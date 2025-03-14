
public class PaymentGatewaymain{
	public static void main(String[] args) {
        // Test Credit Card Payment
        PaymentGateway creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        if (creditCardPayment.validatePayment()) {
            creditCardPayment.processPayment(500.00);
        }

        // Test Debit Card Payment
        PaymentGateway debitCardPayment = new DebitCardPayment("9876-5432-1234-8765", "Jane Smith");
        if (debitCardPayment.validatePayment()) {
            debitCardPayment.processPayment(300.00);
        }

        // Test UPI Payment
        PaymentGateway upiPayment = new UPIPayment("john.smith@upi");
        if (upiPayment.validatePayment()) {
            upiPayment.processPayment(150.00);
        }
    }
}
