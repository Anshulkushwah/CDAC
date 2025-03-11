//import java.util.Scanner;

public class PartTimeEmployee extends  Employee {
	
	float hourlyRate;
	
	public PartTimeEmployee(float hourlyRate,int employeeId,
											String name, String department) {
		
		super(employeeId,name,department);
        this.hourlyRate = hourlyRate;
    }
	
	public float calculateTotalCompensation(int hoursWorked){
		return hoursWorked * hourlyRate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PartTimeEmployee partTimeEmp = new PartTimeEmployee(20.5f, 101, "John Doe", "HR");
		
		System.out.println("Employee Name: " + partTimeEmp.getName());
        System.out.println("Employee Department: " + partTimeEmp.getDepartment());
        System.out.println("Employee ID: " + partTimeEmp.getEmployeeId());
		
		int hoursWorked = 40;
        System.out.println("Total Compensation for " + hoursWorked +
        		" hours worked: $" + partTimeEmp.calculateTotalCompensation(hoursWorked));
	}

}
