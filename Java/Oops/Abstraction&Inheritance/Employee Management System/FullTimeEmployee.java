class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, String employeeId, double monthlySalary) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
    }

    // Calculate salary for full-time employee (fixed monthly salary)
    @Override
    public double calculateSalary() {
        salary = monthlySalary;
        return salary;
    }
}
