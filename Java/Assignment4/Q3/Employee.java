import java.io.Serializable;

class Employee implements Serializable {
    private int id;
    private String name;
    private String designation;
    private double salary;
    private int experience;

    public Employee(int id, String name, String designation, double salary, int experience) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.experience = experience;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setExperience(int experience) { this.experience = experience; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary + ", Experience: " + experience;
    }
	
}
