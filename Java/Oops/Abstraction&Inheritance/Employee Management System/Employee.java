public abstract class Employee {
    protected String name;
    protected String employeeId;
    protected double salary;

    // Constructor to initialize common attributes
    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();
    
    // Getter methods for the common attributes (optional)
    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }


    // Display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}
