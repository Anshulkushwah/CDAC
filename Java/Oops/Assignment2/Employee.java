
public class Employee {
	int employeeId;
	String name;
	String department;

	public Employee(int employeeId, String name, String department) {
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
	}
	
	// Getters (optional, but useful for accessing properties)
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
	

}
