
public class BankAccount {
	
	int accno;
	String accname;
	double amount;

	public BankAccount(int accno, String accname, double initialAmount) {
        this.accno = accno;
        this.accname = accname;
        this.amount = initialAmount;
    }
	
	public void deposit(double depositAmount) {
        if (depositAmount > 0) {
            amount += depositAmount;
            System.out.println("Deposited: Rs. " + depositAmount);
        } else {
            System.out.println("Deposit amount should be greater than zero.");
        }
    }
	
	public void withdraw(double withdrawAmount) {
        if (withdrawAmount > 0 && withdrawAmount <= amount) {
            amount -= withdrawAmount;
            System.out.println("Withdrawn: Rs. " + withdrawAmount);
        } else if (withdrawAmount > amount) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Withdrawal amount should be greater than zero.");
        }
    }
	
	public double interest(double rate) {
        return amount * rate / 100;
    }
	
	public void displayAccountDetails() {
        System.out.println("Account Number: " + accno);
        System.out.println("Account Holder: " + accname);
        System.out.println("Current Balance: Rs. " + amount);
    }

}
