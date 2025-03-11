// Base class Account
class Account {
    String accountNumber;
    String accountHolderName;
    double balance;

    // Constructor
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money (common for both types)
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}

// Subclass SavingsAccount that extends Account
class SavingsAccount extends Account {
    double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    // Method to calculate interest
    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    // Override display method to include interest rate
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    // Method to apply interest to the balance
    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest of $" + interest + " applied. New balance: $" + balance);
    }
}

// Subclass CurrentAccount that extends Account
class CurrentAccount extends Account {
    double overdraftLimit;

    // Constructor
    public CurrentAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw method to handle overdraft
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
            return true;
        } else {
            System.out.println("Insufficient balance and overdraft limit.");
            return false;
        }
    }

    // Override display method to include overdraft limit
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }

    // Method to check overdraft status
    public void checkOverdraft() {
        if (balance < 0) {
            System.out.println("You have overdrafted. Current balance: $" + balance);
        } else {
            System.out.println("You have a positive balance: $" + balance);
        }
    }
}

// Main class to test the system
public class BankingSystem {
    public static void main(String[] args) {
        // Create instances of SavingsAccount and CurrentAccount
        SavingsAccount savings = new SavingsAccount("S12345", "John Doe", 5000.0, 2.5);
        CurrentAccount current = new CurrentAccount("C12345", "Jane Smith", 1000.0, 500.0);

        // Perform operations on Savings Account
        System.out.println("Savings Account Details:");
        savings.displayAccountDetails();
        savings.deposit(500.0);
        savings.withdraw(200.0);
        savings.applyInterest();
        savings.displayAccountDetails();

        // Perform operations on Current Account
        System.out.println("\nCurrent Account Details:");
        current.displayAccountDetails();
        current.deposit(1000.0);
        current.withdraw(1200.0);
        current.checkOverdraft();
        current.withdraw(1800.0); // Exceeds balance + overdraft limit
        current.displayAccountDetails();
    }
}
