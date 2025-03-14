public class UPIPayment implements PaymentGateway {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        // Process the UPI payment (e.g., through UPI API)
        System.out.println("Processing UPI Payment of amount: " + amount);
    }

    @Override
    public boolean validatePayment() {
        // Validate if the UPI ID is correct and the UPI account is active
        // For simplicity, assume validation is successful.
        System.out.println("Validating UPI...");
        return true;  // Assume successful validation for the example.
    }
}