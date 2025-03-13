
public class EmployeeMain {
	
	public static void main(String[] args) {
        // Create a full-time employee
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("John Doe", "FT001", 5000.00);
        fullTimeEmployee.calculateSalary();
        fullTimeEmployee.displayDetails();
        System.out.println("Full-Time Employee Salary: " + fullTimeEmployee.getSalary() + "\n");

        // Create a contract employee
        ContractEmployee contractEmployee = new ContractEmployee("Jane Smith", "CT001", 20.00, 160);
        contractEmployee.calculateSalary();
        contractEmployee.displayDetails();
        System.out.println("Contract Employee Salary: " + contractEmployee.getSalary() + "\n");
    }

}
