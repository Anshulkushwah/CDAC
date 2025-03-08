import java.util.Scanner;
public class BankAccountMain {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating Account object with initial details
        System.out.print("Enter Account Number: ");
        int accno = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Account Holder Name: ");
        String accname = sc.nextLine();
        System.out.print("Enter Initial Deposit Amount: ");
        double initialAmount = sc.nextDouble();

        BankAccount myAccount = new BankAccount(accno, accname, initialAmount);

        // Test the methods
        System.out.println("\nAccount Details:");
        myAccount.displayAccountDetails();

        // Deposit test
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        myAccount.deposit(depositAmount);

        // Withdraw test
        System.out.print("\nEnter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        myAccount.withdraw(withdrawAmount);

        // Interest test
        System.out.print("\nEnter annual interest rate (in %): ");
        double interestRate = sc.nextDouble();
        double interest = myAccount.interest(interestRate);
        System.out.println("Interest on current balance: Rs. " + interest);

        // Display updated account details
        System.out.println("\nUpdated Account Details:");
        myAccount.displayAccountDetails();

        sc.close();
    }
}
