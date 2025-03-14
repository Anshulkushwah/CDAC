
public class CreditCardPayment implements PaymentGateway {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void processPayment(double amount) {
        // Process the credit card payment (e.g., through an external API)
        System.out.println("Processing Credit Card Payment of amount: " + amount);
    }

    @Override
    public boolean validatePayment() {
        // Validate if the credit card details are correct and the card is not expired
        // For simplicity, assume validation is successful.
        System.out.println("Validating Credit Card...");
        return true;  // Assume successful validation for the example.
    }
}