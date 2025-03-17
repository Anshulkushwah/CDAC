// User-defined exception class for Insufficient Funds
class InsufficientFundsException extends Exception {
    // Constructor to accept a custom message
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Class to represent CheckingAccount
class CheckingAccount {
    private double balance;

    // Constructor to initialize balance
    public CheckingAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to withdraw funds from the account
    public void withdraw(double amount) throws InsufficientFundsException {
        // Check if the account has enough funds for the withdrawal
        if (amount > balance) {
            // If not, throw InsufficientFundsException
            throw new InsufficientFundsException("Insufficient funds. Attempted to withdraw: " + amount + ", but balance is: " + balance);
        }
        // If funds are sufficient, subtract the amount from the balance
        balance -= amount;
        System.out.println("Withdrawal successful! Current balance: " + balance);
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}

public class BankAccountApp {
    public static void main(String[] args) {
        // Create a CheckingAccount with an initial balance of 500
        CheckingAccount account = new CheckingAccount(500.0);

        // Display the initial balance
        System.out.println("Initial balance: " + account.getBalance());

        // Try to withdraw an amount
        try {
            account.withdraw(200);  // This should be successful
            account.withdraw(400);  // This should throw an InsufficientFundsException
        } catch (InsufficientFundsException e) {
            // Handle the exception and display the error message
            System.out.println(e.getMessage());
        }
    }
}

