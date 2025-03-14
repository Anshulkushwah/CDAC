public class DebitCardPayment implements PaymentGateway {
    private String debitCardNumber;
    private String cardHolderName;

    public DebitCardPayment(String debitCardNumber, String cardHolderName) {
        this.debitCardNumber = debitCardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void processPayment(double amount) {
        // Process the debit card payment (e.g., through an external API)
        System.out.println("Processing Debit Card Payment of amount: " + amount);
    }

    @Override
    public boolean validatePayment() {
        // Validate if the debit card details are correct and the card is active
        // For simplicity, assume validation is successful.
        System.out.println("Validating Debit Card...");
        return true;  // Assume successful validation for the example.
    }
}