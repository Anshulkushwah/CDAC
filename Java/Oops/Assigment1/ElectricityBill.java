
public class ElectricityBill {
	String customer_number;
	String customer_name;
	int units_consumed;
	
	public void readData(String number,String name, int consumed) {
		customer_number = number;
		customer_name = name;
		units_consumed = consumed;
	}
	
	public void showData() {
        System.out.println("Customer Number: " + customer_number);
        System.out.println("Customer Name: " + customer_name);
        System.out.println("Units Consumed: " + units_consumed);
    }
	
	public double computeBill() {
        double billAmount = 0;
        
        // Calculating bill based on the given rate structure
        if (units_consumed <= 100) {
            billAmount = units_consumed * 1.20;
        } else if (units_consumed <= 300) {
            billAmount = 100 * 1.20 + (units_consumed - 100) * 2.00;
        } else if (units_consumed <= 600) {
            billAmount = 100 * 1.20 + 200 * 2.00 + (units_consumed - 300) * 3.00;
        } else {
            billAmount = 100 * 1.20 + 200 * 2.00 + 300 * 3.00 + (units_consumed - 600) * 5.00;
        }
        
        return billAmount;
    }
	
}
