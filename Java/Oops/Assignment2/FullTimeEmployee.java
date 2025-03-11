
public class FullTimeEmployee extends Employee{

	int Salary;
	
	public FullTimeEmployee(int Salary,int employeeId,
											String name, String department) {
		
		super(employeeId,name,department);
        this.Salary = Salary;
    }
	
	public int calculateTotalCompensation(){
		return Salary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FullTimeEmployee FullTime = new FullTimeEmployee(20000, 101, "John Doe", "HR");
		
		System.out.println("Employee Name: " + FullTime.getName());
        System.out.println("Employee Department: " + FullTime.getDepartment());
        System.out.println("Employee ID: " + FullTime.getEmployeeId());
		

        System.out.println("Total Compensation for FullTimeEmployee " +FullTime.calculateTotalCompensation());
	}


}
