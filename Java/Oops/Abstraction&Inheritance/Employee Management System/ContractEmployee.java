class ContractEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Calculate salary for contract employee (hourly wage)
    @Override
    public double calculateSalary() {
        salary = hourlyRate * hoursWorked;
        return salary;
    }
}
