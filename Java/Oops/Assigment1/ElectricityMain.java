import java.util.Scanner;

public class ElectricityMain {

	public static void main(String[] args) {

        ElectricityBill bill = new ElectricityBill();
        
        Scanner sc = new Scanner(System.in);
        
        // Read customer details
        System.out.print("Enter customer number: ");
        String number = sc.nextLine();
        
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();
        
        // Set the data using the readData method
        bill.readData(number, name, units);
        
        // Display customer details
        bill.showData();
        
        // Compute and display the bill
        double totalBill = bill.computeBill();
        System.out.println("Total Bill to be paid: Rs. " + totalBill);
        
 
        sc.close();
	}

}
