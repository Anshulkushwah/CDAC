import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EmployeeMain {
    private static final String FILE_NAME = "employees.dat";

    public static void addEmployee(Employee emp) {
        ArrayList<Employee> employees = getAllEmployees();
        employees.add(emp);
        saveEmployees(employees);
    }

    public static void updateEmployee(int id, String newDesignation, double newSalary, int newExperience) {
        ArrayList<Employee> employees = getAllEmployees();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setDesignation(newDesignation);
                emp.setSalary(newSalary);
                emp.setExperience(newExperience);
            }
        }
        saveEmployees(employees);
    }

    public static void deleteEmployee(int id) {
        ArrayList<Employee> employees = getAllEmployees();
        employees.removeIf(emp -> emp.getId() == id);
        saveEmployees(employees);
    }

    public static Employee searchEmployee(int id) {
        for (Employee emp : getAllEmployees()) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public static void displayAllEmployees() {
        for (Employee emp : getAllEmployees()) {
            System.out.println(emp);
        }
    }

    public static void getPromotionEligibleEmployees() {
        for (Employee emp : getAllEmployees()) {
            if (emp.getExperience() >= 5) {
                System.out.println(emp);
            }
        }
    }

    private static ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (ArrayList<Employee>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Ignore, file will be created when first employee is added
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private static void saveEmployees(ArrayList<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Alice", "Developer", 70000, 6));
        addEmployee(new Employee(2, "Bob", "Designer", 50000, 3));
        addEmployee(new Employee(3, "Charlie", "Manager", 90000, 8));
        
        System.out.println("All Employees:");
        displayAllEmployees();
        
        System.out.println("\nEmployees Eligible for Promotion:");
        getPromotionEligibleEmployees();
    }
}
